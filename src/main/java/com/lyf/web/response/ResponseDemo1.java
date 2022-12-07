package com.lyf.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1");
        //重定向
        //1、设置响应状态码302
       /* response.setStatus(302);
        //2、设置响应头 location
        response.setHeader("Location","ResponseDemo2");*/

        //简化重定向
        response.sendRedirect("ResponseDemo2");

        /*动态获取虚拟目录*/
        String contextPath = request.getContextPath();
        /*response.sendRedirect(contextPath+"/ResponseDemo2");*/ //新版不需要加虚拟目录


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
