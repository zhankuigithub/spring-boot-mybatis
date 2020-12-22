package com.zk.springboot.service;

import com.zk.springboot.db.sys.bean.Doctor;

import java.util.List;

public interface ISysService {

    List<Doctor> getAllDoctor();

    List<Doctor> getDoctorByID(List<Integer> list);

}
