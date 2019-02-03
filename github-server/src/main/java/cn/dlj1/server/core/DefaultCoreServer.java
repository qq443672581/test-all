package cn.dlj1.server.core;

import cn.dlj1.server.suport.BaseHandler;
import cn.dlj1.server.suport.Controller;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DefaultCoreServer implements CoreServer{

    long time = 0;
    HttpServer server = null;
    Executor executor = Executors.newFixedThreadPool(10);
    Map<String, BaseHandler> instances = new HashMap<>();

    public DefaultCoreServer(int port, Class<? extends BaseHandler>... classes) {
        time = System.currentTimeMillis();
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < classes.length; i++) {
            Class<? extends BaseHandler> clazz = classes[i];
            Controller controller = clazz.getAnnotation(Controller.class);

            BaseHandler bh = instances.get(clazz.getName());
            if(null == bh){
                try {
                    instances.put(clazz.getName(), clazz.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                bh = instances.get(clazz.getName());
            }

            BaseHandler finalBh = bh;
            server.createContext(controller.value(), httpExchange -> {
                executor.execute(() -> {
                    try {
                        finalBh.handle(httpExchange);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });
        }

    }

    @Override
    public void start() {
        server.start();
        System.out.println(String.format("启动用时:%dms",(System.currentTimeMillis() - time)));

    }

}
