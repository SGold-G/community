package com.community;

import com.community.dao.DiscussPostMapper;
import com.community.dao.UserMapper;
import com.community.entity.DiscussPost;
import com.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MybitisTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void test1(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void test2(){
        User user = userMapper.selectByName("SYSTEM");
        System.out.println(user);
    }

    @Test
    public void test3(){
        User user = new User();
        user.setUsername("sgold");
        user.setPassword("123456");
        int i = userMapper.insertUser(user);
    }

    @Test
    public void test4(){
        User user = userMapper.selectById(150);
        System.out.println(user);
        int i = userMapper.updateStatus(150,1);
        System.out.println(i);
        User user1 = userMapper.selectById(150);
        System.out.println(user1);
    }

    @Test
    public void test5(){
        User user = userMapper.selectById(150);
        System.out.println(user);
        int i = userMapper.updateHeader(150,"www.baidu.com");
        System.out.println(i);
        User user1 = userMapper.selectById(150);
        System.out.println(user1);
    }

    @Test
    public void test6(){
        int count = discussPostMapper.getDiscussCount(149);
        List<DiscussPost> list = discussPostMapper.getDiscussByUid(149,1, 10);
        for(DiscussPost list1: list){
            System.out.println(list1);
        }
        System.out.println(count);
    }



}
