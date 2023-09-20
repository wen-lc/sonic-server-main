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
import org.cloud.sonic.controller.models.domain.MtVersion;

import java.io.Serializable;
import java.util.Date;
@Schema(name = "Mt版本信息模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MtVersionDTO implements Serializable, TypeConverter<MtVersionDTO, MtVersion> {

    private Integer id;
    @NotBlank
    private Integer projectId;
    @NotBlank
    private String versionName;

    private String description;
    @NotBlank
    private Boolean deleted;
    @NotBlank
    private String creator;

    private String rewriter;
    @NotBlank
    private Date createTime;

    private Date updateTime;

}
