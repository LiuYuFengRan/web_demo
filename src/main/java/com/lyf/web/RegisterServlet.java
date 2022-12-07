package com.lyf.web;

import com.lyf.mapper.UserMapper;
import com.lyf.pojo.User;
import com.lyf.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.接收用户数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //2.封装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //3.调用mapper根据用户名查询用户对象
        //2.1获取SqlSessionFactory对象
/*        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3获取Mapper
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //调用方法
        User u=userMapper.selectByUsername(username);
        //判断用户对象是否为null
        if(u==null){
            //用户名不存在，添加用户
            userMapper.add(user);

            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
        }else{
            //用户名存在，给出提示信息

            response.getWriter().write("用户名已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
