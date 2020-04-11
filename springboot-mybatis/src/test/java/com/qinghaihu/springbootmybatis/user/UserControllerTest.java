package com.qinghaihu.springbootmybatis.user;

import com.qinghaihu.springbootmybatis.SpringbootUnitTest;
import com.qinghaihu.springbootmybatis.dao.SysUserDao;
import com.qinghaihu.springbootmybatis.entity.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/**
 * @ClassName UserControllerTest
 * @Description TODO
 * @Author:Zhang Lianzhong
 * @Date 2020/4/11 6:13 下午
 * @Version 1.0
 **/
public class UserControllerTest extends SpringbootUnitTest {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    protected WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }



    @Test
    public void testQuery() throws Exception {
        //准备测试数据
        String id = "4";
        String userName = "qinghaihu";
        SysUser orgSysUser = new SysUser();
        orgSysUser.setId(id);
        orgSysUser.setUsername(userName);
        orgSysUser.setPassword("88889998");
        orgSysUser.setCreatetime(new Date());
        orgSysUser.setUserdesc("奔跑吧程序猿");
        orgSysUser.setUserimg("/user/images/qinghaihu.jpg");
        orgSysUser.setUserstate(-1);
        int insertCount = sysUserDao.insert(orgSysUser);
        assertEquals(insertCount,1);


        RequestBuilder request = null;

        /*
         * 1、MockMvcRequestBuilders.post("XXX")构造一个post请求。
         * 2、mockMvc.perform执行一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE)设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *    比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
         */
        //post提交一个people
        request = post("/SysUser/query")
                .param("id",id);
        String json = mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",is(userName)))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

    }

}
