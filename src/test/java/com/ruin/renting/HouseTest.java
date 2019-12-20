package com.ruin.renting;

import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.dao.SysUserRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author ruin
 * @date 2019/12/20-10:39
 */

@SpringBootTest
public class HouseTest {

    @Autowired
    SysUserRepository userRepository;

    @Autowired
    HouseRepository houseRepository;

    @Test
    public void findHouseByOwner(){
        SysUser user=userRepository.findById(4).get();
        houseRepository.findHouseByOwner(user, PageRequest.of(0, 10));

        System.out.println("OK");
    }
}
