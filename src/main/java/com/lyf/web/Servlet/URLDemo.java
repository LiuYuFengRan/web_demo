package com.lyf.web.Servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username="张三";
        /*URL编码*/
        String encode= URLEncoder.encode(username,"utf-8");
        System.out.println(encode);
        /*解码*/
        String decode = URLDecoder.decode(encode,"utf-8");
        System.out.println(decode);
    }
}
