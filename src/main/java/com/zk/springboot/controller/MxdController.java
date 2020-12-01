package com.zk.springboot.controller;

import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import com.zk.springboot.service.IMxdService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("mxd")
public class MxdController {

    @Resource
    private IMxdService mIMxdService;

    @Value("${server.port}")
    private String port;

    private static final String LOCK = "SINGLE_LOCK";

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public IPacket list() {
        System.out.println(this.port);
        return new CommonResult<>(0, mIMxdService.list());
    }

}
