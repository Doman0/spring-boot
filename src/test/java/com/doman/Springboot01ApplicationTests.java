package com.doman;

import com.doman.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class Springboot01ApplicationTests {

    @Test
    public void test() {
        User u1 = new User("zs","11111111",new Date(),12,"","0" );
        System.out.println(u1);

        User u = new User();
        u.setName("zs");
        u.setPassword("11111111");
        u.setBirthday(new Date());
        u.setDesc("描述");
        System.out.println(u);

        System.out.println(u1.equals(u));
    }

  /*  User(name=zhang, password=aa, birthday=Wed Apr 15 21:35:37 CST 2020, desc=)
    User(name=zs, password=11111111, birthday=Wed Apr 15 21:35:37 CST 2020, desc=描述)*/
}
