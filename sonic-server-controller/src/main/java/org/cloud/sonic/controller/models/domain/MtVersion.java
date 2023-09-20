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
import org.cloud.sonic.controller.models.dto.MtVersionDTO;

import java.io.Serializable;
import java.util.Date;

@Schema(name ="mt_version对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("mt_version")
@TableComment("mt版本表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class MtVersion implements Serializable, TypeConverter<MtVersion, MtVersionDTO> {

    @TableId(value = "id_", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;
    @TableField(value = "")
    @Column(value = "",isNull = false)
    private Integer projectId;
    @TableField(value = "")
    @Column(value = "",isNull = false)
    private String versionName;
    @TableField(value = "description_")
    @Column(value = "")
    private String description;
    @TableField(value = "deleted_")
    @Column(value = "",isNull = false)
    private Boolean deleted;
    @TableField(value = "creator_")
    @Column(value = "",isNull = false)
    private String creator;
    @TableField(value = "rewriter_")
    @Column(value = "")
    private String rewriter;
    @TableField(value = "")
    @Column(value = "",isNull = false)
    private Date createTime;
    @TableField(value = "")
    @Column(value = "")
    private Date updateTime;

}