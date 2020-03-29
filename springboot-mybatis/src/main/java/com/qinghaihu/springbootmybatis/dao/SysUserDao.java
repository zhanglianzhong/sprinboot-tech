package com.qinghaihu.springbootmybatis.dao;

import com.qinghaihu.springbootmybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserDao {

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysUser record);

    int deleteByPrimaryKey(String id);
}