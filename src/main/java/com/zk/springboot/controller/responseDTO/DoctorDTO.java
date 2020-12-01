package com.zk.springboot.controller.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DoctorDTO {
    @JsonProperty("doctor_id")
    private int doctorID;

    @JsonProperty("doctor_name")
    private String doctorName;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("gender")
    private int gender;

    @JsonProperty("department_id")
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
