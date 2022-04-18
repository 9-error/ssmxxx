package com.zz.admin.mapper;

import com.zz.admin.bean.Stu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuMapper {

    public Stu getStu(Long id);

}
