package com.zk.springboot.controller.requestbody.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JacksonXmlRootElement(localName = "msg:inboundMessageNotification")
@JsonIgnoreProperties(ignoreUnknown = true)
public class XMLBodyDTO {

    @JacksonXmlProperty(localName = "inboundMessage")
    private InboundMessageDTO inboundMessageDTO;

}
