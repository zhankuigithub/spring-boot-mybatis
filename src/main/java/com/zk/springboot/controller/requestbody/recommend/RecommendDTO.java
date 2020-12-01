package com.zk.springboot.controller.requestbody.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class RecommendDTO implements Serializable {

    @JsonProperty("recommend_type")
    private String recommendType;

    @JsonProperty("expire")
    private long expire;

    @JsonProperty("good_disease")
    private BaseFiledDTO goodDiseaseDTO;

    @JsonProperty("province")
    private BaseFiledDTO provinceDTO;

    @JsonProperty("city")
    private BaseFiledDTO cityDTO;

    @JsonProperty("department")
    private BaseFiledDTO departmentDTO;

    @JsonProperty("all")
    private BaseFiledDTO allDTO;

    @JsonProperty("byid")
    private BaseFiledDTO byID;

}
