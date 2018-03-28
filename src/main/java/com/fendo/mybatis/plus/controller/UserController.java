/**
 * projectName: mybatis-plus
 * fileName: UserController.java
 * packageName: com.fendo.mybatis.plus.controller
 * date: 2018-03-27 10:26
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fendo.mybatis.plus.common.utils.*;
import com.fendo.mybatis.plus.common.web.BaseController;
import com.fendo.mybatis.plus.entity.UserEntity;
import com.fendo.mybatis.plus.entity.enums.AgeEnum;
import com.fendo.mybatis.plus.entity.enums.GenderEnum;
import com.fendo.mybatis.plus.request.UserRequest;
import com.fendo.mybatis.plus.service.UserService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserController
 * @packageName: com.fendo.mybatis.plus.controller
 * @description: 用户Controller
 * @data: 2018-03-27 10:26
 **/
@Controller
@RequestMapping("/user")
@Api(value = "/user", description = "用户操作接口")
@Validated
public class UserController extends BaseController{

    @Autowired
    protected UserService userService;

    /**
     * 用户新增与更新
     * @param data
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    @ApiOperation(value = "更新用户信息", notes = "更新或者保存用户信息")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "invalid input")})
    public ResultData<CustomPage<UserEntity>> save(@RequestBody @ApiParam(name="用户对象",value="传入JSON格式",required=true) UserRequest data) {
        ResultData<CustomPage<UserEntity>> result = null;
        CustomPage<UserEntity> customPage = null;
        if(validates(validator, data)!=null){
            result = new ResultData<CustomPage<UserEntity>>(SimpleCode.ERROR.getCode(), validates(validator, data));
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(data,userEntity);
        if(StringUtils.isNotEmpty(userEntity.getId())){
            userEntity.updateById();
        }else {
            userEntity.insert();
        }
        Page<UserEntity> userEntityPage = userEntity.selectPage(new Page<UserEntity>(0, 12), null);
        customPage = new CustomPage<UserEntity>(userEntityPage);
        result = new ResultData<CustomPage<UserEntity>>(SimpleCode.SUCCESS, customPage);
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "通过用户id删除用户", httpMethod = "GET")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 405, message = "权限不足") })
    @GetMapping("/delete")
    @ResponseBody
    public ResultData<String> delete(@NotEmpty(message = "用户ID不能为空") @ApiParam(value = "用户ID)", required = true) @RequestParam String id){
        ResultData<String> result;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        result = new ResultData(userEntity.deleteById(),"用户删除");
        return result;
    }

    /**
     * 根据用户ID获取用户
     * @param id
     * @return
     */
    @GetMapping("/get")
    @ResponseBody
    @ApiOperation(value = "获取用户信息", notes = "更新ID获取用户信息")
    public ResultData<UserEntity> get(@NotEmpty(message = "用户ID不能为空") @ApiParam(value = "用户ID)", required = true) @RequestParam String id){
        UserEntity userEntity = userService.selectById(id);
        return new ResultData<UserEntity>(SimpleCode.SUCCESS,userEntity);
    }

    /**
     * 参数模式分页
     * @param page
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "size", value = "一页大小", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "current", value = "当前页码", required = false, dataType = "String", paramType = "query"),
    })
    @ApiOperation(value = "自带分页", notes = "分页获取数据")
    public ResultData<CustomPage<UserEntity>> lis(Page page) {
        CustomPage<UserEntity> customPage = new CustomPage<UserEntity>(userService.selectPage(page));
        return  new ResultData<CustomPage<UserEntity>>(SimpleCode.SUCCESS, customPage);
    }


    /**
     * 分页
     * @param frontPage
     * @return
     */
    @PostMapping("/page")
    @ResponseBody
    @ApiOperation(value = "自定义分页", notes = "分页获取数据")
    public ResultData<CustomPage<Map<String,Object>>> page(@ApiParam(required = false, value = "分页参数") @RequestBody(required=false) FrontPage<UserRequest> frontPage) {
        CustomPage<Map<String,Object>> customPage = new CustomPage<Map<String,Object>>(userService.getPage(frontPage.getPagePlus(),frontPage.getParam()));
        return  new ResultData<CustomPage<Map<String,Object>>>(SimpleCode.SUCCESS, customPage);
    }

}
