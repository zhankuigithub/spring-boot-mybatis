package com.zk.springboot.controller;


import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import com.zk.springboot.service.ILolService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("lol")
public class LolController {

    @Resource
    private ILolService mILolService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public IPacket list() {
        return new CommonResult<>(0, mILolService.list());
    }

}
