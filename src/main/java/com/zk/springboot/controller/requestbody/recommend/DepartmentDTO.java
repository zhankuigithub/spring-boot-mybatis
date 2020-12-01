package com.zk.springboot.controller.requestbody.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DepartmentDTO {

    @JsonProperty("department")
    private String department;

    @JsonProperty("province")
    private String province;

    @JsonProperty("city")
    private String city;

    @JsonProperty("size")
    private int size;

    @JsonProperty("base_info")
    private BaseInfoDTO baseInfo;

}
