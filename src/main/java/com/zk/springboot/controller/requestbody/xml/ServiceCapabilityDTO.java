package com.zk.springboot.controller.requestbody.xml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ServiceCapabilityDTO {

    private String capabilityId;

    private String version;

}
