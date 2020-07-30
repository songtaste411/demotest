package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();
    @Select("select * from user ")
    List<User> findAll();

    @Insert(" insert into user  (name) values (#{name}) ")
    public int save(User user);

    @Delete(" delete from user where id= #{id} ")
    public void delete(int id);

    @Select("select * from user where id= #{id} ")
    public User get(int id);

    @Update("update user set name=#{name} where id=#{id} ")
    public int update(User user);

//    @Select("select user where password=#{password} and name=#{name}")
    public User loging(User user);
}
