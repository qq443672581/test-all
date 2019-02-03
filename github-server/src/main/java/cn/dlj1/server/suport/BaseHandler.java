package cn.dlj1.server.suport;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public abstract class BaseHandler implements HttpHandler{

    public abstract String handler(HttpExchange httpExchange);

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String result = handler(exchange);
        if(null != result){
            OutputStream os = exchange.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
    }
}
