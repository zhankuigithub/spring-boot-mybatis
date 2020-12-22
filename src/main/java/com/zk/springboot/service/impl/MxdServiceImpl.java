package com.zk.springboot.service.impl;

import com.zk.springboot.db.mxd.bean.Arms;
import com.zk.springboot.db.mxd.mapper.DBMxdMapper;
import com.zk.springboot.service.IMxdService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("IMxdServerImpl")
public class MxdServiceImpl implements IMxdService {

    @Resource
    private DBMxdMapper mDBMxdMapper;

    @Override
    public List<Arms> list() {
        return mDBMxdMapper.list();
    }
}
