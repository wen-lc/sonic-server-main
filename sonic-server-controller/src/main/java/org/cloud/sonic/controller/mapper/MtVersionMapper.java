package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.cloud.sonic.controller.models.domain.MtVersion;

import java.util.List;

@Mapper
public interface MtVersionMapper extends BaseMapper<MtVersion> {
    @Select("select a.* from mt_version a where a.project_id=#{id}")
    List<MtVersion> selectByPid(Integer id);
}