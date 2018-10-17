package cn.dlj1.jfinal.controller;

import com.jfinal.core.Controller;

public class TestController extends Controller {

    public void index() {
        renderText("123");
    }
}
