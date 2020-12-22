package com.zk.springboot.controller.requestbody.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InboundMessageDTO {

    private String conversationID;

    private String contributionID;

    private String senderAddress;

    private String destinationAddress;

    private String messageId;

    private String contentType;

    private String contentEncoding;

    private String dateTime;

    @JacksonXmlProperty(localName = "serviceCapability")
    private ServiceCapabilityDTO serviceCapabilityDTO;

    private String bodyText;

    private String origUser;

    private String resourceURL;

    private LinkDTO link;

}
