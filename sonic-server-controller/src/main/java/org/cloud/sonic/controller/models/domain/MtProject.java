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
import org.cloud.sonic.controller.models.dto.MtProjectDTO;
import org.cloud.sonic.controller.models.dto.MtUserDTO;

import java.io.Serializable;
import java.util.Date;
@Schema(name ="mt_project对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("mt_project")
@TableComment("mt项目表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class MtProject implements Serializable, TypeConverter<MtProject, MtProjectDTO> {

    @TableId(value = "id_", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;
    @TableField(value = "")
    @Column(value = "",isNull = false)
    private String projectName;
    @TableField(value = "imported_")
    @Column(value = "imported_",isNull = false)
    private Boolean imported;
    @TableField(value = "")
    @Column(value = "")
    private String projectDesc;
    @TableField(value = "")
    @Column(value = "",isNull = false)
    private String directoryPath;
    @TableField(value = "")
    @Column(value = "")
    private String jiraProjects;
    @TableField(value = "")
    @Column(value = "")
    private String wechatMachine;
    @TableField(value = "color_")
    @Column(value = "color_")
    private String color;
    @TableField(value = "")
    @Column(value = "")
    private Integer issueTemplateId;
    @TableField(value = "")
    @Column(value = "")
    private Integer caseTemplateId;
    @TableField(value = "")
    @Column(value = "",isNull = false)
    private Date createTime;
    @TableField(value = "")
    @Column(value = "")
    private Date updateTime;
    @TableField(value = "creator_")
    @Column(value = "creator_",isNull = false)
    private String creator;
    @TableField(value = "rewriter_")
    @Column(value = "rewriter_")
    private String rewriter;
}