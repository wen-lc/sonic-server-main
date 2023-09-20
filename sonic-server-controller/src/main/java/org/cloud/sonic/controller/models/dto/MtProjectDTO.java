package org.cloud.sonic.controller.models.dto;


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
import org.cloud.sonic.controller.models.domain.MtProject;
import org.cloud.sonic.controller.models.domain.MtUser;
import org.wildfly.common.annotation.NotNull;

import java.io.Serializable;
import java.util.Date;
@Schema(name = "Mt项目信息模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MtProjectDTO implements Serializable, TypeConverter<MtProjectDTO, MtProject> {


    private Integer id;
    @NotBlank
    private String projectName;
    @NotBlank
    private Boolean imported;

    private String projectDesc;

    @NotBlank
    private String directoryPath;

    private String jiraProjects;

    private String wechatMachine;

    private String color;

    private Integer issueTemplateId;

    private Integer caseTemplateId;
    @NotBlank
    private Date createTime;

    private Date updateTime;
    @NotBlank
    private String creator;

    private String rewriter;
}
