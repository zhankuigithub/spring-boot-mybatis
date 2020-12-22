package com.zk.springboot.service.impl;

import com.zk.springboot.db.mxd.bean.Arms;
import com.zk.springboot.db.mxd.mapper.DBMxdMapper;
import com.zk.springboot.service.IMxdService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component("MxdServerImpl2")
public class MxdServerImpl2 implements IMxdService {

    @Resource
    private DBMxdMapper mDBMxdMapper;

    @Override
    public List<Arms> list() {
        List<Arms> list = mDBMxdMapper.list();
        list.add(new Arms(3, "木精灵枪", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        return list;
    }
}
