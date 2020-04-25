package com.ssm.test;

import com.ssm.dao.UserDao;
import com.ssm.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: 贝阿人
 * @DATE: 2020/4/21
 * @Reference：https://www.bilibili.com/video/BV1mE411X7yp
 */
public class daoTest {

    public static void main(String[] args) throws IOException {
         //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlmapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用sqlSession创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> lists = userDao.findAllUser();
        for(User user : lists){
            System.out.println(user);
        }
        //6.释放资源
        ///123
        session.close();
        in.close();
    }
}