package server;

import server.controller.TestController;
import server.core.DefaultCoreServer;

public class Start {

    public static void main(String[] arg) {
        new DefaultCoreServer(7777,
                TestController.class
        ).start();
    }

}
