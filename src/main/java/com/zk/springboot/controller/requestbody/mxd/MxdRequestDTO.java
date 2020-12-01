package com.zk.springboot.controller.requestbody.mxd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class MxdRequestDTO implements Serializable {

    @JsonProperty("arms_name")
    private String armsName;

}
