/**
 * projectName: mybatis-plus
 * fileName: UserEntityMapper.java
 * packageName: com.fendo.mybatis.plus.mapper
 * date: 2018-03-24 18:20
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.mapper;

import com.fendo.mybatis.plus.common.persistent.SuperMapper;
import com.fendo.mybatis.plus.entity.UserEntity;
import com.fendo.mybatis.plus.request.UserRequest;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserEntityMapper
 * @packageName: com.fendo.mybatis.plus.mapper
 * @description: 用户Mapper
 * @data: 2018-03-24 18:20
 **/
public interface UserEntityMapper extends SuperMapper<UserEntity> {

    /**
     * 删除所有数据
     * @return
     */
    int deleteAll();

    /**
     * 根据SQL获取列表
     * @return
     */
    @Select("select *  from user")
    List<UserEntity> selectListBySQL();

    /**
     * 用户分页
     * @param page
     * @param userRequest
     * @return
     */
    List<Map<String,Object>> getPage(Pagination page, UserRequest userRequest);
}
