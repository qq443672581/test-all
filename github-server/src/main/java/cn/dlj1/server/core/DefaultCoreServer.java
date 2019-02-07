package cn.dlj1.server.core;

import cn.dlj1.server.suport.BaseHandler;
import cn.dlj1.server.suport.Controller;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class DefaultCoreServer implements CoreServer{

    private static Logger logger = Logger.getLogger(DefaultCoreServer.class.getName());

    long time = 0;
    HttpServer server = null;
    Executor executor = null;

    private void init(int port, int poolSize, Class<? extends BaseHandler>... classes){
        time = System.currentTimeMillis();
        try {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1",port), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < classes.length; i++) {
            Class<? extends BaseHandler> clazz = classes[i];
            Controller controller = clazz.getAnnotation(Controller.class);

            server.createContext(controller.value(), httpExchange -> {
                executor.execute(() -> {
                    try {
                        logger.info(String.format("request [%s]", controller.value()));
                        BaseHandler bh = null;
                        try {
                            bh = clazz.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                        bh.handle(httpExchange);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });
        }
    }

    public DefaultCoreServer(int port, Class<? extends BaseHandler>... classes) {
        init(port, 5, classes);
    }

    @Override
    public void start() {
        server.start();
        logger.info(String.format("启动用时:%dms",(System.currentTimeMillis() - time)));

    }

}
