package com.d1.sptest.mapper;
import com.d1.sptest.emity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user;")
    List<User> findAll();

@Insert("INSERT INTO sys_user(username,password,nikename,email,phone,address) VALUES (#{username},#{password},#{nikename},#{email},#{phone},#{address})")
    int insert(User user);
    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select  * from sys_user where username like concat('%' , #{username} , '%') limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize,String username);

    @Select("select count(*) from sys_user where username like concat('%',#{username},'%')")
    Integer selectTotal(String username);
}
