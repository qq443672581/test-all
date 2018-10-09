package cn.dlj1.simple;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class Java8Date {
    public static void main(String[] args) throws UnsupportedEncodingException {

        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime.getYear());

    }
}
