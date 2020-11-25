package com.zk.springboot.db.lol.mapper;

import com.zk.springboot.db.lol.bean.Equip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DBLolMapper {

    List<Equip> list();

}
