import com.will.mapper.UserMapper;
import com.will.pojo.User;
import com.will.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);

    @org.junit.Test
    public void selectUser(){
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int currentPage = 1;  //第几页
        int pageSize = 2;  //每页显示几个
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startindex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> users = mapper.selectUser(map);
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
        User user = mapper.selectUserByNameAndPwd();
        System.out.println(user);
        session.close();
    }

    @Test
    public void insertUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",6);
        map.put("name","张杰2");
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
