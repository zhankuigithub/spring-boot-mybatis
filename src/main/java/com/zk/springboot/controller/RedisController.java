package com.zk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import com.zk.springboot.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;


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


    @GetMapping("test")
    public IPacket test() throws JSONException {


        return new CommonResult<>();
    }


    public static void main(String[] args) throws JSONException, JsonProcessingException {
        String session = "4U73D1kyrcCO8Rl3ePRONPwrQ3PgCfNPeupDib1IaTQ";

        //   post1();
        //   post2(session);
        //post3(session);

        //post5(session);

        post4(session);


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

        String s = getSortJsonMap(json).toString();
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


    private static void post2(String sessionID) throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "chat");
        json.put("intent", "triage");
        json.put("session", sessionID);

        Map params = new HashMap<String, Object>();

        params.put("text", "症状自查");

        json.put("params", params);

        String s = getSortJsonMap(json).toString();
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

    private static void post3(String sessionID) throws JSONException {
        String url = "https://interface.39.net/saas-triage/aiinquiry";

        Map json = new HashMap<String, Object>();
        json.put("action", "select");
        json.put("intent", "triage");
        json.put("session", sessionID);

        Map params = new HashMap<String, Object>();

        params.put("option", "全身");

        json.put("params", params);

        String s = getSortJsonMap(json).toString();
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

        String s = getSortJsonMap(json).toString();
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

        String s = getSortJsonMap(json).toString();
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

        String query = formatUrlMap(paraMap, false, true);

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


    public static JSONObject getSortJsonMap(Map mm) throws JSONException {
        Iterator<String> iteratorKeys = mm.keySet().iterator();
        SortedMap map = new TreeMap<String, Object>();
        while (iteratorKeys.hasNext()) {
            String key = iteratorKeys.next();
            Object o = mm.get(key);
            map.put(key, o);
        }
        Object wrap = JSONObject.wrap(map);
        return (JSONObject) wrap;
    }

    public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
        String buff = "";
        Map<String, String> tmpMap = paraMap;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, Comparator.comparing(Map.Entry::getKey));

            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower) {
                        buf.append(key.toLowerCase() + "=" + val);
                    } else {
                        buf.append(key + "=" + val);
                    }
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e) {
            return null;
        }
        return buff;
    }

}
