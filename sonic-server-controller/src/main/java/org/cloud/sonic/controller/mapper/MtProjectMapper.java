package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.cloud.sonic.controller.models.domain.Modules;
import org.cloud.sonic.controller.models.domain.MtProject;

import java.util.List;

@Mapper
public interface MtProjectMapper extends BaseMapper<MtProject> {

    @Select("select a.* from mt_project a left join mt_project_user b on a.id_ = b.project_id" +
            " where b.user_id=#{id}")
    List<MtProject> selectByUId(int id);
}