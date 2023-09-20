package org.cloud.sonic.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.cloud.sonic.controller.models.domain.MtUser;
import org.cloud.sonic.controller.models.domain.Users;
import org.cloud.sonic.controller.models.dto.MtUserDTO;

import java.util.List;

@Mapper
public interface MtUserMapper extends BaseMapper<MtUser> {

}