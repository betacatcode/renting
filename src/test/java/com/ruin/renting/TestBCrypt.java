package com.ruin.renting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author ruin
 * @date 2019/12/8-21:21
 */

@SpringBootTest
public class TestBCrypt {

    @Test
    public void testBCrypt(){
//        对密码进行加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);

        String hashpw1 = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw1);

    }
}
