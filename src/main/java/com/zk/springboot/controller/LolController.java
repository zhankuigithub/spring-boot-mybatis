package com.zk.springboot.controller;


import com.zk.springboot.db.lol.bean.Equip;
import com.zk.springboot.service.ILolService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("lol")
public class LolController {

    @Resource
    private ILolService mILolService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Equip> list() {
        return mILolService.list();
    }

}
