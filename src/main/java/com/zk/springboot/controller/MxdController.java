package com.zk.springboot.controller;

import com.zk.springboot.db.mxd.bean.Arms;
import com.zk.springboot.service.IMxdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("mxd")
public class MxdController {

    @Resource
    private IMxdService mIMxdService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Arms> list() {
        return mIMxdService.list();
    }

}
