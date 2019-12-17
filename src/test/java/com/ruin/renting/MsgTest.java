package com.ruin.renting;

import com.ruin.renting.dao.MsgRepository;
import com.ruin.renting.domain.Msg;
import com.ruin.renting.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ruin
 * @date 2019/12/12-19:58
 */
@SpringBootTest
public class MsgTest {
    @Autowired
    MsgRepository msgRepository;

    @Autowired
    UserService userService;

    @Test
    public void getContacts(){
        List<Integer> contactsIds = msgRepository.getContactsId(5);
        for(Integer contactsId:contactsIds)
            System.out.println(contactsId);
    }

    @Test
    public void getChatInformation(){
        List<Msg> chatInformation = userService.getChatInformation(4, 6);

        for (Msg msg:chatInformation)
            System.out.println(msg);
    }
}
