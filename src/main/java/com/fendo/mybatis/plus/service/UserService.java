/**
 * projectName: mybatis-plus
 * fileName: UserService.java
 * packageName: com.fendo.mybatis.plus.service
 * date: 2018-03-24 18:21
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.fendo.mybatis.plus.entity.UserEntity;
import com.fendo.mybatis.plus.request.UserRequest;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserService
 * @packageName: com.fendo.mybatis.plus.service
 * @description: 用户Service
 * @data: 2018-03-24 18:21
 **/
public interface UserService extends IService<UserEntity> {

    /**
     * 删除所有数据
     * @return
     */
    boolean deleteAll();

    /**
     * 用户分页
     * @param page
     * @param userRequest
     * @return
     */
    Page<Map<String,Object>> getPage(Page<UserRequest> page, UserRequest userRequest);

    /**
     * 根据SQL获取列表
     * @return
     */
    List<UserEntity> selectListBySQL();

}
