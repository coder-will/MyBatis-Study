package com.will.mapper;

import com.will.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Mapper是提供方法的接口，实现不由它管
 */
public interface UserMapper {
    //查询所有学生，返回List集合
    List<User> selectUser();

    //根据Id查询学生
    User selectUserById(int id);

    //根据密码和名字查询用户 用map集合
    User selectUserByNameAndPwd(Map map);

    //插入用户
    int insertUser(Map map);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

}
