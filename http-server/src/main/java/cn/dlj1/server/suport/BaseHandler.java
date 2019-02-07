package cn.dlj1.server.suport;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class BaseHandler implements HttpHandler{

    public abstract Object handler();

    private HttpExchange exchange;

    private int responseStatus = 200;

    public void addResponseHeader(String name, String value){
        exchange.getResponseHeaders().add(name, value);
    }

    @Override
    public final void handle(HttpExchange exchange) throws IOException {
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

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Headers getRequestHeaders(){
        return exchange.getRequestHeaders();
    }

    public String getRequestContentType(){
        List<String> list = getRequestHeaders().get("Content-Type");
        if(null == list || list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public InputStream getRequestBody(){
        return exchange.getRequestBody();
    }

    public String getRequestBodyStr(){
        try {
            return IOUtils.toString(exchange.getRequestBody(),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
