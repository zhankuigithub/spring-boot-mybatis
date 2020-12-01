package com.zk.springboot.controller.requestbody.recommend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class BaseFiledDTO implements Serializable {

    @JsonProperty("field_name")
    private String fieldName;

    @JsonProperty("info")
    private String info;

    @JsonProperty("norm_max")
    //@JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double normMax;

    @JsonProperty("norm_min")
    private double normMin;

    @JsonProperty("ctr_type")
    private String ctrType;

    @JsonProperty("url")
    private String url;

    @JsonProperty("timeout")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double timeout;


}
