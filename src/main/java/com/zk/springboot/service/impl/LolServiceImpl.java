package com.zk.springboot.service.impl;

import com.zk.springboot.db.lol.bean.Equip;
import com.zk.springboot.db.lol.mapper.DBLolMapper;
import com.zk.springboot.service.ILolService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class LolServiceImpl implements ILolService {

    @Resource
    private DBLolMapper mDBLolMapper;

    @Override
    public List<Equip> list() {
        return mDBLolMapper.list();
    }

}
