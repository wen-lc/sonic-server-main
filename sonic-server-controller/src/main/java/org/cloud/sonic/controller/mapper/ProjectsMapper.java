package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cloud.sonic.controller.models.domain.MtProject;
import org.cloud.sonic.controller.models.domain.Projects;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author JayWenStar
 * @since 2021-12-17
 */
@Mapper
public interface ProjectsMapper extends BaseMapper<Projects> {


    @Insert({
            "<script>",
            "insert ignore into  projects(id, project_name, project_des,project_img,robot_token,robot_type,global_robot) values ",
            "<foreach collection='testLists' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.projectName}, #{item.projectDesc}, '','',-1,1)",
            "</foreach>",
            "</script>"
    })
    int projectMoving(@Param(value="testLists")List<MtProject> mtProjects);
}
