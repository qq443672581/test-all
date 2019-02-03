package cn.dlj1.server.controller;

import cn.dlj1.server.suport.BaseHandler;
import cn.dlj1.server.suport.Controller;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

@Controller("/test")
public class TestController extends BaseHandler{

    @Override
    public String handler(HttpExchange exchange) {
        try {
            exchange.sendResponseHeaders(200, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "你好，世界!";
    }

}
