/*
 *   sonic-server  Sonic Cloud Real Machine Platform.
 *   Copyright (C) 2022 SonicCloudOrg
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Affero General Public License as published
 *   by the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Affero General Public License for more details.
 *
 *   You should have received a copy of the GNU Affero General Public License
 *   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.cloud.sonic.controller.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.cloud.sonic.common.config.WebAspect;
import org.cloud.sonic.common.config.WhiteUrl;
import org.cloud.sonic.common.exception.SonicException;
import org.cloud.sonic.common.http.RespEnum;
import org.cloud.sonic.common.http.RespModel;
import org.cloud.sonic.controller.mapper.MtProjectMapper;
import org.cloud.sonic.controller.mapper.MtVersionMapper;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.MtProject;
import org.cloud.sonic.controller.models.domain.MtVersion;
import org.cloud.sonic.controller.models.domain.Projects;
import org.cloud.sonic.controller.models.dto.ProjectsDTO;
import org.cloud.sonic.controller.models.dto.UsersDTO;
import org.cloud.sonic.controller.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ZhouYiXun
 * @des
 * @date 2021/9/9 22:46
 */
@Tag(name = "项目管理相关")
@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @Autowired
    private MtProjectMapper mtProjectMapper;

    @Autowired
    private MtVersionMapper mtVersionMapper;

    @WebAspect
    @Operation(summary = "更新项目信息", description = "新增或更新项目信息")
    @PutMapping
    public RespModel<String> save(@Validated @RequestBody ProjectsDTO projects) {
        projectsService.save(projects.convertTo());
        return new RespModel<>(RespEnum.UPDATE_OK);
    }

    @WebAspect
    @WhiteUrl
    @Operation(summary = "查找所有项目", description = "查找所有项目列表")
    @GetMapping("/list")
    public RespModel<List<ProjectsDTO>> findAll() {
        return new RespModel<>(
                RespEnum.SEARCH_OK,
                projectsService.findAll().stream().map(TypeConverter::convertTo).collect(Collectors.toList())
        );
    }

    @WebAspect
    @Operation(summary = "查询项目信息", description = "查找对应id下的详细信息")
    @Parameter(name = "id", description = "项目id")
    @GetMapping
    public RespModel<?> findById(@RequestParam(name = "id") int id) {
        Projects projects = projectsService.findById(id);
        if (projects != null) {
            return new RespModel<>(RespEnum.SEARCH_OK, projects.convertTo());
        } else {
            return new RespModel<>(RespEnum.ID_NOT_FOUND);
        }
    }

    @WebAspect
    @Operation(summary = "删除", description = "删除对应id下的详细信息")
    @Parameter(name = "id", description = "项目id")
    @DeleteMapping
    public RespModel<String> delete(@RequestParam(name = "id") int id) throws SonicException {
        projectsService.delete(id);
        return new RespModel<>(RespEnum.DELETE_OK);
    }

    @WebAspect
    @WhiteUrl
    @Operation(summary = "项目搬家", description = "将mt项目表中的数据新增到本系统中")
    @PostMapping("/projectMoving")
    public RespModel<String> projectMoving() throws SonicException {
        int i = projectsService.projectMoving();
        if (i > 0) {
            return new RespModel<>(2000, "ok.success");
        } else {
            return new RespModel<>(2000, "ok.success");
        }
    }

    @WebAspect
    @WhiteUrl
    @Operation(summary = "获取版本号", description = "获取当前的版本号")
    @GetMapping("/getVersions")
    public RespModel<List> getVersions(@RequestParam(name = "id") int id) throws SonicException {
        List<MtVersion> versions = mtVersionMapper.selectByPid(id);
        return new RespModel<>(2000, "result.clean",versions);
    }

    @WebAspect
    @WhiteUrl
    @Operation(summary = "获取项目", description = "获取该用户参与的项目集合")
    @GetMapping("/getProjects")
    public RespModel<List> getProjects(@RequestParam(name = "id") int id) {
        List<MtProject> mtProjects = mtProjectMapper.selectByUId(id);
        if (mtProjects != null) {
            return new RespModel<>(2000, "result.clean", mtProjects);
        } else {
            return new RespModel<>(2001, "result.clean");
        }
    }
}
