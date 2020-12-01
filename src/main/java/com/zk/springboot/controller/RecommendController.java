package com.zk.springboot.controller;

import com.zk.springboot.controller.requestbody.recommend.DepartmentDTO;
import com.zk.springboot.controller.requestbody.recommend.DiseaseDTO;
import com.zk.springboot.controller.requestbody.recommend.PrimaryDTO;
import com.zk.springboot.controller.requestbody.recommend.RecommendRequestDTO;
import com.zk.springboot.controller.responseDTO.DoctorDTO;
import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "recommend")
public class RecommendController {


    @PostMapping("all")
    public IPacket all(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        DoctorDTO response = new DoctorDTO();
        return new CommonResult<>(response);
    }


    @PostMapping("byid")
    public IPacket byid(@RequestBody PrimaryDTO primaryDTO) {
        System.out.println(primaryDTO);
        DoctorDTO response = new DoctorDTO();
        return new CommonResult<>(response);
    }

    @PostMapping("bydepartment")
    public IPacket bydepartment(@RequestBody DepartmentDTO departmentDTO) {
        DoctorDTO response = new DoctorDTO();
        return new CommonResult<>(response);
    }

    @PostMapping("bydisease")
    public IPacket bydisease(@RequestBody DiseaseDTO diseaseDTO) {

        DoctorDTO response = new DoctorDTO();
        return new CommonResult<>(response);
    }

}
