package com.zk.springboot.db.mxd.mapper;

import com.zk.springboot.db.mxd.bean.Arms;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DBMxdMapper {

    List<Arms> list();

}
