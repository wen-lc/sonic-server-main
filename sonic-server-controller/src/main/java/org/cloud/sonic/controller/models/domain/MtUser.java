package org.cloud.sonic.controller.models.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.dto.MtUserDTO;
import org.cloud.sonic.controller.models.dto.UsersDTO;

import java.io.Serializable;
import java.util.Date;

@Schema(name ="mt_user对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("mt_user")
@TableComment("mt用户表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class MtUser implements Serializable, TypeConverter<MtUser, MtUserDTO> {

    @TableId(value = "id_", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;

    @TableField(value = "username_")
    @Column(value = "username_",isNull = false)
    private String username;

    @TableField(value = "password_")
    @Column(value = "password_")
    private String password;

    @TableField
    @Column(value = "user_email",isNull = false)
    private String userEmail;

    @TableField
    @Column(value = "user_photo")
    private String userPhoto;
    @TableField
    @Column(value = "real_name",isNull = false)
    private String realName;
    @TableField
    @Column(value = "user_resource",isNull = false)
    private String userResource;
    @TableField
    @Column(value = "user_status",isNull = false)
    private String userStatus;
    @TableField
    @Column(value = "last_login_time")
    private Date lastLoginTime;
    @TableField
    @Column(value = "user_type",isNull = false)
    private String userType;
    @TableField
    @Column(value = "project_id")
    private Integer projectId;
    @TableField
    @Column(value = "wechat_user_id")
    private String wechatUserId;
    @TableField
    @Column(value = "directory_path")
    private String directoryPath;
    @TableField
    @Column(value = "captcha_times",isNull = false)
    private Integer captchaTimes;
    @TableField
    @Column(value = "locked_times",isNull = false)
    private Integer lockedTimes;
    @TableField(value = "deleted_")
    @Column(value = "deleted_",isNull = false)
    private Boolean deleted;
    @TableField
    @Column(value = "create_time",isNull = false)
    private Date createTime;
    @TableField
    @Column(value = "update_time")
    private Date updateTime;
    @TableField(value = "creator_")
    @Column(value = "creator_",isNull = false)
    private String creator;
    @TableField(value = "rewriter_")
    @Column(value = "rewriter_")
    private String rewriter;
}