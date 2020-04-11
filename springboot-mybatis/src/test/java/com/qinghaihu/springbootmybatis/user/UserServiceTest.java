package com.qinghaihu.springbootmybatis.user;

import com.qinghaihu.springbootmybatis.SpringbootUnitTest;
import com.qinghaihu.springbootmybatis.dao.SysUserDao;
import com.qinghaihu.springbootmybatis.entity.SysUser;
import com.qinghaihu.springbootmybatis.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName UserServiceTest
 * @Description TODO
 * @Author:Zhang Lianzhong
 * @Date 2020/4/11 5:12 下午
 * @Version 1.0
 **/

public class UserServiceTest extends SpringbootUnitTest {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserDao sysUserDao;


    @Test
    public void testInsert(){
        SysUser sysUser = new SysUser();
        String id = "5";
        sysUser.setId(id);
        sysUser.setUsername("qinghaihudream");
        sysUser.setPassword("88888887");
        sysUser.setCreatetime(new Date());
        sysUser.setUserdesc("奔跑吧程序猿");
        sysUser.setUserimg("/user/images/qinghaihu.jpg");
        sysUser.setUserstate(-1);

        boolean insertResult = sysUserService.insertUserInfo(sysUser);
        assertTrue(insertResult);

        SysUser queryedUser = sysUserDao.selectByPrimaryKey(id);
        assertEquals(queryedUser.getUsername(),sysUser.getUsername());
    }

    @Test
    public  void testSelect(){
        SysUser sysUser = new SysUser();
        String id = "5";
        sysUser.setId(id);
        sysUser.setUsername("qinghaihudream");
        sysUser.setPassword("88888887");
        sysUser.setCreatetime(new Date());
        sysUser.setUserdesc("奔跑吧程序猿");
        sysUser.setUserimg("/user/images/qinghaihu.jpg");
        sysUser.setUserstate(-1);

        int insertResult = sysUserDao.insert(sysUser);
        assertEquals(insertResult,1);

        SysUser queryedUser = sysUserService.selectById(id);
        assertEquals(queryedUser.getUsername(),sysUser.getUsername());

    }

    @Test
    public void testUpdate() {

        //准备测试数据
        String id = "4";
        String orgUserDesc = "你好程序猿";
        String updateUserDesc = "奔跑吧程序猿";

        SysUser orgSysUser = new SysUser();
        orgSysUser.setId(id);
        orgSysUser.setUsername("qinghaihu");
        orgSysUser.setPassword("88889998");
        orgSysUser.setCreatetime(new Date());
        orgSysUser.setUserdesc(orgUserDesc);
        orgSysUser.setUserimg("/user/images/qinghaihu.jpg");
        orgSysUser.setUserstate(-1);
        int insertCount = sysUserDao.insert(orgSysUser);
        assertEquals(insertCount,1);

        SysUser updateSysUser = new SysUser();
        updateSysUser.setId(id);
        updateSysUser.setUsername("qinghaihu");
        updateSysUser.setPassword("88889998");
        updateSysUser.setCreatetime(new Date());
        updateSysUser.setUserdesc(updateUserDesc);
        updateSysUser.setUserimg("/user/images/qinghaihu.jpg");
        updateSysUser.setUserstate(-1);


        boolean updateResult = sysUserService.updateUserInfo(updateSysUser);
        assertTrue(updateResult);

        //检查数据是否更新
        SysUser queryedUser = sysUserService.selectById(id);
        assertEquals(queryedUser.getUserdesc(),updateUserDesc);


    }

    @Test
    public void testdelete() {
        SysUser sysUser = new SysUser();
        String id = "5";
        sysUser.setId(id);
        sysUser.setUsername("qinghaihudream");
        sysUser.setPassword("88888887");
        sysUser.setCreatetime(new Date());
        sysUser.setUserdesc("奔跑吧程序猿");
        sysUser.setUserimg("/user/images/qinghaihu.jpg");
        sysUser.setUserstate(-1);

        boolean insertResult = sysUserService.insertUserInfo(sysUser);
        assertTrue(insertResult);

        boolean deleteResult = sysUserService.deleteById(id);
        assertTrue(deleteResult);

        //检查数据是否删除
        SysUser queryedUser = sysUserService.selectById(id);
        assertNull(queryedUser);

    }


}
