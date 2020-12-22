package com.zk.springboot.db.sys.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Doctor implements Serializable {

    @JsonProperty("doctor_id")
    private int doctorID;

    @JsonProperty("doctor_name")
    private String doctorName;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("gender")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int gender;

    @JsonProperty("department_id")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int departmentID;

    @JsonProperty("department")
    private String department;

    @JsonProperty("hospital_id")
    private String hospitalID;

    @JsonProperty("hospital")
    private String hospital;

    @JsonProperty("province_id")
    private String provinceID;

    @JsonProperty("province")
    private String province;

    @JsonProperty("good_disease")
    private String goodDisease;

    @JsonProperty("city_id")
    private String cityID;

    @JsonProperty("city")
    private String city;
}
