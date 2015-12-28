package com.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
  

public class APIHttpClient {  
	  
    // 接口地�?  
    private static String apiURL = "http://localhost:18080/menjin/unauth/login";  
    private Log logger = LogFactory.getLog(this.getClass());  
    private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";  
    private HttpClient httpClient = null;  
    private HttpPost method = null;  
    private long startTime = 0L;  
    private long endTime = 0L;  
    private int status = 0;  
  
    /** 
     * 接口地�? 
     *  
     * @param url 
     */  
    public APIHttpClient(String url) {  
  
        if (url != null) {  
            this.apiURL = url;  
        }  
        if (apiURL != null) {  
            httpClient = new DefaultHttpClient();  
            method = new HttpPost(apiURL);  
  
        }  
    }  
  
    /** 
     * �?用 API 
     *  
     * @param parameters 
     * @return 
     */  
    public String post(String parameters) {  
        String body = null;  
        logger.info("parameters:" + parameters);  
  
        if (method != null & parameters != null  
                && !"".equals(parameters.trim())) {  
            try {  
  
                // 建立�?个NameValuePair数�?��用于存储欲�?送的参数  
                method.addHeader("Content-type","application/json; charset=utf-8");  
                method.setHeader("Accept", "application/json");  
                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));  
                startTime = System.currentTimeMillis();  
  
                HttpResponse response = httpClient.execute(method);
                System.out.println("header start===================================");
                System.out.println(response.getFirstHeader("Set-Cookie").getValue());
                System.out.println("header end===================================");
                endTime = System.currentTimeMillis();  
                int statusCode = response.getStatusLine().getStatusCode();  
                  
                logger.info("statusCode:" + statusCode);  
                logger.info("�?用API 花费时间(单位：毫�?)?�?" + (endTime - startTime));  
                if (statusCode != HttpStatus.SC_OK) {  
                    logger.error("Method failed:" + response.getStatusLine());  
                    status = 1;  
                }  
  
                // Read the response body  
                body = EntityUtils.toString(response.getEntity());  
  
            } catch (IOException e) {  
                // 网络错误  
                status = 3;  
            } finally {  
                logger.info("�?用接口状�?�?" + status);  
            }  
  
        }  
        return body;  
    }  
    
    public String get(String url, String sessionId) {  
        String body = null;  
        logger.info("parameters:" + url);  
  
            try {  
  
                // 建立�?个NameValuePair数�?��用于存储欲�?送的参数  
            	  startTime = System.currentTimeMillis();  
            	 HttpClient httpclient = new DefaultHttpClient(); 
                 HttpGet httpgets = new HttpGet("http://localhost:18080/menjin/auth/getUsers");    
                 httpgets.setHeader("Cookie:", "JSESSIONID=" + sessionId);
                 HttpResponse response = httpclient.execute(httpgets);
                  
                endTime = System.currentTimeMillis();  
                int statusCode = response.getStatusLine().getStatusCode();  
                  
                logger.info("statusCode:" + statusCode);  
                logger.info("�?用API 花费时间(单位：毫�?)?�?" + (endTime - startTime));  
                if (statusCode != HttpStatus.SC_OK) {  
                    logger.error("Method failed:" + response.getStatusLine());  
                    status = 1;  
                }  
  
                // Read the response body  
                body = EntityUtils.toString(response.getEntity());  
  
            } catch (IOException e) {  
                // 网络错误  
                status = 3;  
            } finally {  
                logger.info("�?用接口状�?�?" + status);  
            }  
        return body;  
    }  
  
    public static void main(String[] args) {  
        APIHttpClient ac = new APIHttpClient(apiURL); 
        Map<String, String> requestParams = new HashMap<String, String>();
        requestParams.put("name", "macx");
        requestParams.put("password", "macx");
        JSONObject j = new JSONObject(requestParams);  
        System.out.println(ac.post(j.toJSONString()));  
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println(ac.get("http://localhost:18080/menjin/auth/getUsers","4EDADE17D2CFCECEE38DDE40654163DB"));    
        

    }  
  
    /** 
     * 0.成功 1.执行方法失败 2.协议错误 3.网络错误 
     *  
     * @return the status 
     */  
    public int getStatus() {  
        return status;  
    }  
  
    /** 
     * @param status 
     *            the status to set 
     */  
    public void setStatus(int status) {  
        this.status = status;  
    }  
  
    /** 
     * @return the startTime 
     */  
    public long getStartTime() {  
        return startTime;  
    }  
  
    /** 
     * @return the endTime 
     */  
    public long getEndTime() {  
        return endTime;  
    }  
}  
