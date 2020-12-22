package com.zk.springboot.service;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Map;

public interface ISaasService {

    JSONObject triageGetSession(Map params);

    JSONObject triageChat(Map params);

    JSONObject triageContinue(Map params);

    JSONObject triageSelect(Map params);

    JSONObject  triageNewSession(Map params);

    JSONObject recommend(Map params);

    void access(Map params);

}
