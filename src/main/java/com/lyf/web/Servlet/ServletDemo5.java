package com.lyf.web.Servlet;

import com.lyf.web.Servlet.MyHttpServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/demo5")
public class ServletDemo5 extends MyHttpServlet {
    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("get..");
    }

    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("post...");
    }
}
