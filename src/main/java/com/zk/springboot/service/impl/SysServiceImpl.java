package com.zk.springboot.service.impl;

import com.zk.springboot.db.sys.bean.Doctor;
import com.zk.springboot.db.sys.mapper.DBSysMapper;
import com.zk.springboot.service.ISysService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SysServiceImpl implements ISysService {

    @Resource
    private DBSysMapper dbSysMapper;

    @Override
    public List<Doctor> getAllDoctor() {
        return dbSysMapper.getAllDoctor();
    }

    @Override
    public List<Doctor> getDoctorByID(List<Integer> list) {
        return dbSysMapper.getDoctorByID(list);
    }
}
