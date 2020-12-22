package com.zk.springboot.controller;

import com.zk.springboot.controller.requestbody.recommend.DepartmentDTO;
import com.zk.springboot.controller.requestbody.recommend.DiseaseDTO;
import com.zk.springboot.controller.requestbody.recommend.PrimaryDTO;
import com.zk.springboot.controller.responsebody.DoctorDTO;
import com.zk.springboot.db.sys.bean.Doctor;
import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import com.zk.springboot.service.ISysService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "recommend")
public class RecommendController {

    @Resource
    private ISysService mSysService;

/**
 *       1. https://interface.39.net/saas-triage/aiinquiry      问诊
 *       2. https://interface.39.net/saas-triage/doctor/recommend    推荐医生
 *       3.https://interface.39.net/saas-tri-test/tri/  推荐医生后，返回一个本次推荐的 session_id，当用户点击列表中的医生时，应该调用 CTR 反馈接口，以便系统能优化精排序
 */


    /**
     * 自动推荐
     * <p>
     * 获取全部推荐资源的接口，主要用于 AI 识别全部推荐资源的擅长疾病，省份，城市，科室。会定时调用该接口同步数据并计算
     *
     * @return
     */
    @PostMapping("all")
    public IPacket all() {
        List<Doctor> list = mSysService.getAllDoctor();
        return new CommonResult<>(list);
    }

    /**
     * 自动推荐
     * 通过 primary_id 指定的唯一 id，以 id 列表方式查询一批推荐资源
     *
     * @param primaryDTO {"primary_ids":[1001744,1001745,1001747]}
     * @return
     */
    @PostMapping("byid")
    public IPacket byID(@RequestBody PrimaryDTO primaryDTO) {
        List<Doctor> list = mSysService.getDoctorByID(primaryDTO.getPrimaryIDs());
        return new CommonResult<>(list);
    }

    /**
     * 直接推荐把推荐请求传给后端接口，由后端接口自己实现推荐结果。传回一个科室名，注意：科室名是智能导诊的
     * 内设科室，后端接口需要转换成自己的科室名
     *
     * @param departmentDTO
     * @return
     */
    @PostMapping("bydepartment")
    public IPacket byDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DoctorDTO response = new DoctorDTO();
        return new CommonResult<>(response);
    }

    /**
     * 直接推荐把推荐请求传给后端接口，由后端接口自己实现推荐结果。传回 5 个带权重值的疾病名
     *
     * @param diseaseDTO
     * @return
     */
    @PostMapping("bydisease")
    public IPacket byDisease(@RequestBody DiseaseDTO diseaseDTO) {
        DoctorDTO response = new DoctorDTO();
        return new CommonResult<>(diseaseDTO);
    }

}
