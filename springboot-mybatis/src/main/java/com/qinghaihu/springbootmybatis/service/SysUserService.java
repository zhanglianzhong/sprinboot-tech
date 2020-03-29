package com.qinghaihu.springbootmybatis.service;

import com.qinghaihu.springbootmybatis.dao.SysUserDao;
import com.qinghaihu.springbootmybatis.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author:Zhang Lianzhong
 * @Date 2020/3/29 7:13 上午
 * @Version 1.0
 **/

@Service
public class SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    public SysUser selectById(String id){
       return sysUserDao.selectByPrimaryKey(id);
    }


    public  boolean updateUserInfo(SysUser sysUser){
        int count = sysUserDao.updateByPrimaryKey(sysUser);
        if(count>0){
            return true;
        }else {
            return false;
        }
    }


    public boolean deleteById(String id){
        int count = sysUserDao.deleteByPrimaryKey(id);
        if(count>0){
            return true;
        }else {
            return  false;
        }
    }

    public boolean insertUserInfo(SysUser sysUser){
        int count = sysUserDao.insert(sysUser);
        if(count>0){
            return true;
        }else {
            return  false;
        }
    }

}
