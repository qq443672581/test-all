package cn.dlj1.server.controller;

import cn.dlj1.server.suport.BaseHandler;
import cn.dlj1.server.suport.Controller;

@Controller("/test")
public class TestController extends BaseHandler{

    @Override
    public Object handler() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            builder.append("你好,世界");
        }

        addResponseHeader("Content-Type","application/json;charset=utf-8");

        return new String[]{"你好","世界"};
    }

}
