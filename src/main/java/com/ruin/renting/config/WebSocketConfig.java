package com.ruin.renting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author ruin
 * @date 2019/12/11-10:50
 */
@Configuration
@EnableWebSocketMessageBroker
/*
 * 通过@EnableWebSocketMessageBroker注解开启试用STOMP协议来传输基于代理（message broker）的消息，这时控制器支持使用@MessageMapping
 * 就像使用@RequestMapping一样
 *
 */
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 将"/endpointWisely"路径注册为STOMP端点，这个路径与发送和接收消息的目的路径有所不同
     * 这是一个端点，客户端在订阅或发布消息到目的地址前，要连接该端点，
     */

    //注册STOMP协议的节点 并映射指定的URL
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个STOMP的endpoint 并指定使用SockJS协议
        registry.addEndpoint("/endpointChat").withSockJS();
    }


    //配置消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式应配置一个/topic消息代理
//        registry.enableSimpleBroker("/topic");
        //点对点式应增加一个名为/queue的消息代理
        registry.enableSimpleBroker("/queue", "/topic");
    }

}
