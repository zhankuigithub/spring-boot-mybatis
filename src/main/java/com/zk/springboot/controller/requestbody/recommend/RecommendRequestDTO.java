package com.zk.springboot.controller.requestbody.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class RecommendRequestDTO implements Serializable {

    @JsonProperty("appid")
    private String appID;

    @JsonProperty("secret")
    private String secret;

    @JsonProperty("name")
    private String name;

    @JsonProperty("primary_id")
    private BaseFiledDTO primaryDTO;

    @JsonProperty("recommend")
    private RecommendDTO recommendDTO;

    @JsonProperty("norm_fields")
    private List<BaseFiledDTO> normFields;

    @JsonProperty("ctr_fields")
    private List<BaseFiledDTO> ctrFields;

}
