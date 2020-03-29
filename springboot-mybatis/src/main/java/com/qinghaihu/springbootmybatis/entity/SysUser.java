package com.qinghaihu.springbootmybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SysUser {

    //用户id
    private String id;

    //用户名
    private String username;

    //密码
    private String password;

    //用户状态
    private Integer userstate;

    //创建时间
    private Date createtime;

    //用户描述
    private String userdesc;

    //用户图像
    private String userimg;

    //所属部门id
    private String deptid;


}