package com.zk.springboot.controller.requestbody.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class DiseaseDTO {

    @JsonProperty("disease")
    List<Map> disease;

    @JsonProperty("province")
    private String province;

    @JsonProperty("city")
    private String city;

    @JsonProperty("size")
    private int size;

    @JsonProperty("base_info")
    private BaseInfoDTO baseInfo;

}
