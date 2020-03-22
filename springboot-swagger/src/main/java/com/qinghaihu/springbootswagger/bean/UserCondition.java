package com.qinghaihu.springbootswagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "用户查询对象")
public class UserCondition {

    @ApiModelProperty(name = "用户id",dataType = "String" ,notes = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "用户名",dataType = "String" ,notes="用户名")
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
