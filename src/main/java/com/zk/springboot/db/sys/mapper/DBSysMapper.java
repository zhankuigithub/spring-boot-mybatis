package com.zk.springboot.db.sys.mapper;

import com.zk.springboot.db.sys.bean.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DBSysMapper {

    List<Doctor> getAllDoctor();

    List<Doctor> getDoctorByID(@Param(("list")) List<Integer> list);

}
