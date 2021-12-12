package com.nowcoder;

import com.nowcoder.community.dao.DiscussMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=NowcoderApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper usermapper;
    @Autowired
    private DiscussMapper discussMapper;
    @Test
    public void test1(){
        User user = usermapper.selectById(151);
        System.out.println(user);
        User user1 = usermapper.selectByName("lxb");
        System.out.println(user1);
//        User user2 = new User();
//        user2.setUsername("ws");
//        user2.setEmail("ws@nowcoder.com");
//        user2.setPassword("ws");
//        user2.setSalt("1234");
//        user2.setHeaderUrl("www.ws.com");
//        user2.setCreateTime(new Date());
//        user2.setActivationCode("1");
//        usermapper.insertUser(user2);
        User user2 = usermapper.selectById(153);
        System.out.println(user2);
    }
    @Test
    public void test02(){

        List<DiscussPost> list = discussMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost dis : list){
            System.out.println(dis);
        }
        int count = discussMapper.selectDiscussPostCount(149);
        System.out.println(count);
    }
}
