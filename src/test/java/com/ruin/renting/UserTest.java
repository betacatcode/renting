package com.ruin.renting;

import com.ruin.renting.dao.SysUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ruin
 * @date 2019/12/10-14:19
 */
@SpringBootTest
public class UserTest {

    @Autowired
    SysUserRepository userRepository;

}
