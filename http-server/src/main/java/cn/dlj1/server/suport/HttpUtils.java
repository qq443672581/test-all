package cn.dlj1.server.suport;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 请求工具类
 */
public class HttpUtils {

    /**
     * get
     *
     * @param url
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        return doRequest(url, true, true, params, "UTF-8");
    }

    private static String toParamString(Map<String, String> data, String encoding) {
        if (null == data || data.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String d : data.keySet()) {
            try {
                sb.append(d).append("=").append(URLEncoder.encode(data.get(d), encoding)).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String s = sb.toString();
        if (s.length() > 0) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    public static String doRequest(String url, boolean isForm, boolean isGet, Map<String, String> data) {
        return doRequest(url, isForm, isGet, data, "UTF-8");
    }

    public static String doRequest(String url, boolean isForm, boolean isGet, Map<String, String> data, String encoding) {
        if (null == url || "".equals(url.trim())) {
            throw new NullPointerException("请求地址不能为空!");
        }

        String sendUrl = url;
        String sendData;
        if (isForm) {
            sendData = toParamString(data, encoding);
        } else {
            sendData = JSON.toJSONString(data);
        }
        if (isGet) {
            sendUrl = url + (url.indexOf("?") == -1 ? "?" : "&") + sendData;
        }
        URL httpUrl;
        String response = null;
        try {
            httpUrl = new URL(sendUrl);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(isGet ? "GET" : "POST");
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setRequestProperty("Content-type", (isForm ? "application/x-www-form-urlencoded" : "application/json") + ";charset=" + encoding);
            connection.setReadTimeout(30000);
            connection.connect();
            if (!isGet) {
                OutputStream os = connection.getOutputStream();
                IOUtils.write(sendData, os, encoding);
                os.close();
            }
            InputStream is = connection.getInputStream();
            response = IOUtils.toString(is, encoding);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String postBody(String url, String body) {
        if (null == url || "".equals(url.trim())) {
            throw new NullPointerException("请求地址不能为空!");
        }

        String sendUrl = url;
        URL httpUrl;
        String response = null;
        try {
            httpUrl = new URL(sendUrl);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setReadTimeout(30000);
            connection.connect();
            OutputStream os = connection.getOutputStream();
            IOUtils.write(body, os, "UTF-8");
            os.close();
            InputStream is = connection.getInputStream();
            response = IOUtils.toString(is, "UTF-8");
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}

