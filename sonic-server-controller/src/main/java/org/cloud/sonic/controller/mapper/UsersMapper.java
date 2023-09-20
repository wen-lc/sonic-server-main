package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cloud.sonic.controller.models.domain.MtProject;
import org.cloud.sonic.controller.models.domain.MtUser;
import org.cloud.sonic.controller.models.domain.Users;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author JayWenStar
 * @since 2021-12-17
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    @Insert({
            "<script>",
            "insert  into  users(id, user_name, password,source) values ",
            "(#{id}, #{userName}, #{password}, #{source})",
            "</script>"
    })
    int insertcom(Users users);

    @Insert({
            "<script>",
            "insert ignore into  users(id, user_name,password,source) values ",
            "<foreach collection='testLists' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.username}, #{item.password},'local')",
            "</foreach>",
            "</script>"
    })
    int usersMoving(@Param(value="testLists") List<MtUser> mtUsers);
}
