package org.cloud.sonic.controller.models.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.MtProject;
import org.cloud.sonic.controller.models.domain.MtProjectUser;

import java.io.Serializable;
import java.util.Date;
@Schema(name = "Mt项目用户关系模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MtProjectUserDTO implements Serializable, TypeConverter<MtProjectUserDTO, MtProjectUser> {


    private Integer id;
    @NotBlank
    private Integer projectId;
    @NotBlank
    private Integer userId;

    private Integer sort;

    private Integer isTop;

    private String rewriter;
    @NotBlank
    private String creator;
    @NotBlank
    private Date createTime;

    private Date updateTime;
}
