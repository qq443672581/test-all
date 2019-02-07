package cn.dlj1.server;

import cn.dlj1.server.controller.TestController;
import cn.dlj1.server.core.DefaultCoreServer;

public class Start {

    public static void main(String[] arg) {
        new DefaultCoreServer(7777,
                TestController.class
        ).start();
    }

}
