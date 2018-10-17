package cn.dlj1.jfinal;

import cn.dlj1.jfinal.controller.TestController;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

public class Start extends JFinalConfig {

    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 80, "/", 5);
    }

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/test", TestController.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }

    @Override
    public void afterJFinalStart() {
        System.out.println("afterJFinalStart");
        super.afterJFinalStart();
    }
}
