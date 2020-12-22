package com.zk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zk.springboot.controller.requestbody.xml.XMLBodyDTO;
import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import com.zk.springboot.util.MD5Utils;
import com.zk.springboot.util.UrlUtils;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    String url = "https://interface.39.net/saas-triage/aiinquiry";

    @Resource
    private RestTemplate restTemplate;

    // 例如：{'intent': 'triage', 'action': 'get_session', 'params': {'gender': 'male', 'age': '3', 'pregnant': 0}}
    //排序后：{'action': 'get_session', 'intent': 'triage', 'params': {'gender': 'male', 'age': '3', 'pregnant': 0}}

    // {"action":"get_session","intent":"triage","params":{"gender":"male","age":"3","pregnant":0}}

    //Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607073408&body={"action":"get_session","intent":"triage","params":{"gender":"male","age":"3","pregnant":0}}


    @PostMapping("test")
    public IPacket test(@RequestBody XMLBodyDTO xmlBodyDTO) throws JSONException {


        // 输出下行发包xml
        System.out.println(xmlBodyDTO.toString());


        if (xmlBodyDTO.getInboundMessageDTO().getContentType().equals("application/vnd.gsma.rcs-ft-http+xml")) {
            String bodyText = xmlBodyDTO.getInboundMessageDTO().getBodyText();
            System.out.println(bodyText);

        }
        return new CommonResult<>();
    }


    public static void main(String[] args) throws JSONException, JsonProcessingException {
        String session = "LeTaMvDsXKR9TkQolX03Xa57roYUuSEIYx07wziHABA";

         post1();
        // post2(session);
        //post3(session);

        //post5(session);

        //post4(session);

        // get();
        //access();

    }

    private static void post1() throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "get_session");
        json.put("intent", "triage");

        Map params = new HashMap<String, Object>();

        params.put("gender", "male");
        params.put("age", "3");
        params.put("pregnant", 0);

        json.put("params", params);

        String s = UrlUtils.getSortJsonMap(json).toString();
        String x = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607073408&body=" + s;
        HttpHeaders headers = new HttpHeaders();


        System.out.println(x);
        System.out.println(MD5Utils.getMD5(x));

        headers.set("Sign", MD5Utils.getMD5(x));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607073408");

        HttpEntity httpEntity = new HttpEntity(s, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        Object wrap = JSONObject.wrap(exchange.getBody());

        System.out.println(wrap);
    }


    private static void post2(String sessionID) throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "new_session");
        json.put("intent", "triage");
        json.put("session", sessionID);

        //Map params = new HashMap<String, Object>();

        //params.put("text", "症状自查");

        //json.put("params", params);

        String s = UrlUtils.getSortJsonMap(json).toString();
        System.out.println(s);

        String x = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607073408&body=" + s;

        System.out.println(x);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(x));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607073408");

        HttpEntity httpEntity = new HttpEntity(s, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        System.out.println(exchange);
    }

    private static void post3(String sessionID) throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "select");
        json.put("intent", "triage");
        json.put("session", sessionID);

        Map params = new HashMap<String, Object>();

        params.put("option", "全身");

        json.put("params", params);

        String s = UrlUtils.getSortJsonMap(json).toString();
        System.out.println(s);

        String x = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607073408&body=" + s;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(x));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607073408");

        HttpEntity httpEntity = new HttpEntity(s, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        System.out.println(exchange);
    }

    private static void post4(String sessionID) throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "select");
        json.put("intent", "triage");
        json.put("session", sessionID);

        Map params = new HashMap<String, Object>();

        List<String> strings = Arrays.asList("恶心", "食欲不振");

        params.put("option", strings);

        json.put("params", params);

        String s = UrlUtils.getSortJsonMap(json).toString();
        System.out.println(s);

        String x = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607073408&body=" + s;
        HttpHeaders headers = new HttpHeaders();

        System.out.println(MD5Utils.getMD5(x));
        headers.set("Sign", MD5Utils.getMD5(x));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607073408");

        HttpEntity httpEntity = new HttpEntity(s, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);


        System.out.println(exchange);
    }

    private static void post5(String sessionID) throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "continue");
        json.put("intent", "triage");
        json.put("session", sessionID);

        Map params = new HashMap<String, Object>();

        json.put("params", params);

        String s = UrlUtils.getSortJsonMap(json).toString();
        System.out.println(s);

        String x = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607073408&body=" + s;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(x));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607073408");

        HttpEntity httpEntity = new HttpEntity(s, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        System.out.println(exchange);
    }


    private static void get() {

        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("disease", "");
        paraMap.put("department", "皮肤科");
        paraMap.put("devprovince", "贵州");
        paraMap.put("devcity", "贵阳");
        paraMap.put("session", "4vnHYZCZStTCwZHyexB3EFUvWhU3H8o6jJi6_hRmB6Q");
        paraMap.put("size", "5");

        String query = UrlUtils.formatUrlMap(paraMap, false, true);

        System.out.println(query);

        String ssss = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607074761&" + query;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(ssss));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607074761");

        HttpEntity httpEntity = new HttpEntity(headers);
        String url = "https://interface.39.net/saas-triage/doctor/recommend?" + ssss;

        ResponseEntity<String> exchange = new RestTemplate().exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(exchange.getBody());
    }


    private static void access() {

        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("doctor_id", "1301108");
        paraMap.put("session_id", "4vnHYZCZStTCwZHyexB3EFUvWhU3H8o6jJi6_hRmB6Q");

        String query = UrlUtils.formatUrlMap(paraMap, false, true);

        String ssss = "Appid=quickapp&Secret=1f112a9784214c6fab2552d0811034ed&Ts=1607074761&" + query;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(ssss));
        headers.set("Appid", "quickapp");
        headers.set("Ts", "1607074761");

        HttpEntity httpEntity = new HttpEntity(headers);
        String url = "https://interface.39.net/saas-triage/doctor/access?" + ssss;

        ResponseEntity<String> exchange = new RestTemplate().exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(exchange.getBody());
    }


}
