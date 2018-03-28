/**
 * projectName: mybatis-plus
 * fileName: UserServiceImpl.java
 * packageName: com.fendo.mybatis.plus.service.impl
 * date: 2018-03-24 18:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fendo.mybatis.plus.entity.UserEntity;
import com.fendo.mybatis.plus.mapper.UserEntityMapper;
import com.fendo.mybatis.plus.request.UserRequest;
import com.fendo.mybatis.plus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserServiceImpl
 * @packageName: com.fendo.mybatis.plus.service.impl
 * @description:
 * @data: 2018-03-24 18:22
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserEntityMapper, UserEntity> implements UserService {

    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    public Page<Map<String, Object>> getPage(Page<UserRequest> page, UserRequest userRequest) {
        Page<Map<String,Object>> resultPage = new Page<Map<String,Object>>();
        resultPage.setRecords(baseMapper.getPage(page,userRequest));
        return resultPage;
    }

    @Override
    public List<UserEntity> selectListBySQL() {
        return baseMapper.selectListBySQL();
    }
}
