package com.lyf.mapper;

import com.lyf.pojo.User;
import org.apache.ibatis.annotations.*;


/**
 * 根据用户名和密码查询用户对象
 */
public interface UserMapper {
    @Select("select *from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询寻用户对象
     * @param username
     * @return
     */
    @Select("select *from tb_user where username=#{username}")
    User selectByUsername(String username);

    /*
    添加用户
     */
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(User user);
}
