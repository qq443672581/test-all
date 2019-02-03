package cn.dlj1.server.suport;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public abstract class BaseHandler implements HttpHandler{

    private HttpExchange exchange;
    private int responseStatus = 200;

    public abstract Object handler();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        this.exchange = exchange;
        // 执行
        Object result = handler();

        exchange.sendResponseHeaders(responseStatus, 0);


        // 填充结果
        if(null != result){
            String str;
            if(result instanceof String){
                str = result.toString();
            }else{
                str = JSON.toJSONString(result);
            }

            OutputStream os = exchange.getResponseBody();
            os.write(str.getBytes());
            os.close();
        }
    }

    public HttpExchange getExchange() {
        return exchange;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}
