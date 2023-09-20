package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cloud.sonic.controller.models.domain.MtProject;
import org.cloud.sonic.controller.models.domain.MtProjectUser;

import java.util.List;

@Mapper
public interface MtProjectUserMapper extends BaseMapper<MtProjectUser> {


}