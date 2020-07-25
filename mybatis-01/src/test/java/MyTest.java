import com.will.mapper.UserMapper;
import com.will.pojo.User;
import com.will.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @org.junit.Test
    public void selectUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void selectUserById(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByNameAndPwd(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","张三");
        map.put("pwd","abcdef");
        User user = mapper.selectUserByNameAndPwd(map);
        System.out.println(user);
        session.close();
    }

    @Test
    public void insertUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",4);
        map.put("name","张杰");
        map.put("pwd","zhangjie");
        mapper.insertUser(map);
        session.commit();
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"张天奕","hehehe"));
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        session.commit();
        session.close();
    }

}
