package com.qinghaihu.springbootmybatis.controller;

import com.qinghaihu.springbootmybatis.entity.SysUser;
import com.qinghaihu.springbootmybatis.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author:Zhang Lianzhong
 * @Date 2020/4/11 6:08 下午
 * @Version 1.0
 **/

@RequestMapping("/SysUser")
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/query")
    public SysUser queryById(String id){
        return  sysUserService.selectById(id);
    }

}
