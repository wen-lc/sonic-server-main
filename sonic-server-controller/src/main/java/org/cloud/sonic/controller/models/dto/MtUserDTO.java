package org.cloud.sonic.controller.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.MtUser;

import java.io.Serializable;
import java.util.Date;

@Schema(name = "Mt用户信息模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MtUserDTO implements Serializable, TypeConverter<MtUserDTO, MtUser> {

    private Integer id;
    @NotBlank
    private String username;

    private String password;
    @NotBlank
    private String userEmail;

    private String userPhoto;
    @NotBlank
    private String realName;
    @NotBlank
    private String userResource;
    @NotBlank
    private String userStatus;

    private Date lastLoginTime;
    @NotBlank
    private String userType;

    private Integer projectId;

    private String wechatUserId;

    private String directoryPath;
    @NotBlank
    private Integer captchaTimes;
    @NotBlank
    private Integer lockedTimes;
    @NotBlank
    private Boolean deleted;
    @NotBlank
    private Date createTime;

    private Date updateTime;
    @NotBlank
    private String creator;

    private String rewriter;
}