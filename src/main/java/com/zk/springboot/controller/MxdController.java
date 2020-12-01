package com.zk.springboot.controller;

import com.zk.springboot.controller.requestbody.mxd.MxdRequestDTO;
import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import com.zk.springboot.service.IMxdService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("mxd")
public class MxdController {

    // 下列2个用法一样
    @Resource(name = "IMxdServerImpl2")
    private IMxdService mIMxdService;

//    @Autowired
//    @Qualifier("IMxdServerImpl2")
//    private  IMxdService mIMxdService;

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public IPacket list() {
        return new CommonResult<>(0, mIMxdService.list());
    }

    @PostMapping(value = "add")
    public IPacket add(@RequestBody MxdRequestDTO mxdRequestDTO) {
        System.out.println(mxdRequestDTO);
        return new CommonResult<>(mxdRequestDTO);
    }

}
