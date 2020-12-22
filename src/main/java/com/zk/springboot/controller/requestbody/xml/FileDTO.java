package com.zk.springboot.controller.requestbody.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "file")
public class FileDTO {

    @JacksonXmlProperty(localName = "file-info")
    private FileInfoDTO fileInfoDTO;


}

class FileInfoDTO {

    @JacksonXmlProperty(localName = "file-size")
    private String fileSize;

    @JacksonXmlProperty(localName = "content-type")
    private String contentType;

    private Data data;

}

@JacksonXmlRootElement(localName = "data")
class Data {

}
