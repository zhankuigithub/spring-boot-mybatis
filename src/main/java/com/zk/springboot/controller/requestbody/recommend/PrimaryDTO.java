package com.zk.springboot.controller.requestbody.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class PrimaryDTO {

    @JsonProperty("primary_ids")
    private List<Integer> primaryIDs;

}
