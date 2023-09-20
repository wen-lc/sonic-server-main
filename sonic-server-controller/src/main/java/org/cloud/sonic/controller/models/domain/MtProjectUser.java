package org.cloud.sonic.controller.models.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.dto.MtProjectUserDTO;

import java.io.Serializable;
import java.util.Date;
@Schema(name ="mt_project_user对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("mt_project_user")
@TableComment("mt项目用户关系表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class MtProjectUser implements Serializable, TypeConverter<MtProjectUser, MtProjectUserDTO> {

    @TableId(value = "id_", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;
    @TableField(value = "project_id")
    @Column(value = "project_id",isNull = false)
    private Integer projectId;
    @TableField(value = "user_id")
    @Column(value = "user_id",isNull = false)
    private Integer userId;
    @TableField(value = "sort_")
    @Column(value = "sort_")
    private Integer sort;
    @TableField(value = "is_top")
    @Column(value = "is_top")
    private Integer isTop;
    @TableField(value = "rewriter_")
    @Column(value = "rewriter_")
    private String rewriter;
    @TableField(value = "creator_")
    @Column(value = "creator_",isNull = false)
    private String creator;
    @TableField(value = "create_time")
    @Column(value = "create_time",isNull = false)
    private Date createTime;
    @TableField(value = "update_time")
    @Column(value = "update_time")
    private Date updateTime;
}