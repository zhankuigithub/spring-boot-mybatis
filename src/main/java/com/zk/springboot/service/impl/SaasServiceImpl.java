package com.zk.springboot.service.impl;

import com.zk.springboot.service.ISaasService;
import com.zk.springboot.util.MD5Utils;
import com.zk.springboot.util.UrlUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class SaasServiceImpl implements ISaasService {

    @Resource
    private RestTemplate restTemplate;

    private static final String AIINQUIRY = "aiinquiry";  // 问诊
    private static final String RECOMMEND = "doctor/recommend";  // 推荐
    private static final String ACCESS = "doctor/access";  // 精排序

    @Value("${saas.url}")
    private String url;

    @Value("${saas.appid}")
    private String appID;

    @Value("${saas.secret}")
    private String secret;

    @Override
    public JSONObject triageGetSession(Map params) {
        params.put("intent", "triage");
        params.put("action", "get_session");
        return getTriageResult(params);
    }

    @Override
    public JSONObject triageChat(Map params) {
        params.put("intent", "triage");
        params.put("action", "chat");
        return getTriageResult(params);
    }

    @Override
    public JSONObject triageContinue(Map params) {
        params.put("intent", "triage");
        params.put("action", "continue");
        return getTriageResult(params);
    }

    @Override
    public JSONObject triageSelect(Map params) {
        params.put("intent", "triage");
        params.put("action", "select");
        return getTriageResult(params);
    }

    @Override
    public JSONObject triageNewSession(Map params) {
        params.put("intent", "triage");
        params.put("action", "new_session");
        return getTriageResult(params);
    }

    @Override
    public JSONObject recommend(Map params) {
        params.put("size", 5);
        return getResult(RECOMMEND, params);
    }

    @Override
    public void access(Map params) {
        getResult(ACCESS, params);
    }

    private JSONObject getTriageResult(Map params) {

        String ts = System.currentTimeMillis() / 1000 + "";
        String body = UrlUtils.getSortJsonMap(params).toString();
        String string = "Appid=" + this.appID + "&Secret=" + this.secret + "&Ts=" + ts + "&body=" + body;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(string));
        headers.set("Appid", this.appID);
        headers.set("Ts", ts);

        HttpEntity httpEntity = new HttpEntity(body, headers);
        return (JSONObject) JSONObject.wrap(restTemplate.exchange(this.url + AIINQUIRY, HttpMethod.POST, httpEntity, String.class).getBody());
    }

    private JSONObject getResult(String uri, Map params) {

        String ts = System.currentTimeMillis() / 1000 + "";
        String body = UrlUtils.getSortJsonMap(params).toString();
        String string = "Appid=" + this.appID + "&Secret=" + this.secret + "&Ts=" + ts + "&" + body;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Sign", MD5Utils.getMD5(string));
        headers.set("Appid", this.appID);
        headers.set("Ts", ts);

        HttpEntity httpEntity = new HttpEntity(body, headers);
        return (JSONObject) JSONObject.wrap(restTemplate.exchange(this.url + uri, HttpMethod.GET, httpEntity, String.class).getBody());
    }

}
