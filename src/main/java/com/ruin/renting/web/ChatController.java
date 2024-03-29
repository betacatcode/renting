package com.ruin.renting.web;

import com.ruin.renting.domain.Msg;
import com.ruin.renting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author ruin
 * @date 2019/12/11-11:00
 */
@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    UserService userService;

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        String[] split = msg.split(":");
        String receiverName=userService.getUsernameById(Integer.valueOf(split[0]));
        String senderName=principal.getName();
        String content=split[1];
        Msg detailMsg = userService.saveMsg(senderName, receiverName, content);

        messagingTemplate.convertAndSendToUser(receiverName,"/queue/notifications",
                detailMsg);
        
    }
}

