package com.qinghaihu.springbootmybatis;


import com.qinghaihu.springbootmybatis.entity.SysUser;
import com.qinghaihu.springbootmybatis.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    SysUserService sysUserService;


    @Test
    public void testInsert(){
        SysUser sysUser = new SysUser();
        sysUser.setId("5");
        sysUser.setUsername("qinghaihu");
        sysUser.setPassword("88888888");
        sysUser.setCreatetime(new Date());
        sysUser.setUserdesc("奔跑吧程序猿");
        sysUser.setUserimg("/user/images/qinghaihu.jpg");
        sysUser.setUserstate(0);

        boolean insertResult = sysUserService.insertUserInfo(sysUser);
        if(insertResult){
            System.out.println("成功插入用户记录！");
        }else {
            System.out.println("插入用户记录失败");
        }
    }

    @Test
    public  void testSelect(){
        String id = "5";
        SysUser sysUser = sysUserService.selectById(id);
        System.out.println(sysUser);
    }

    @Test
    public void testUpdate() {
        SysUser sysUser = new SysUser();
        sysUser.setId("5");
        sysUser.setUsername("qinghaihu");
        sysUser.setPassword("88889999");
        sysUser.setCreatetime(new Date());
        sysUser.setUserdesc("奔跑吧程序猿");
        sysUser.setUserimg("/user/images/qinghaihu.jpg");
        sysUser.setUserstate(0);

        boolean updateResult = sysUserService.updateUserInfo(sysUser);
        if (updateResult) {
            System.out.println("成功修改用户信息！");
        } else {
            System.out.println("修改用户信息失败");
        }

    }

    @Test
    public void testdelete() {
        String id = "5";
        boolean deleteResult = sysUserService.deleteById(id);

        if (deleteResult) {
            System.out.println("成功删除用户信息！");
        } else {
            System.out.println("删除用户信息失败");
        }
    }


}
