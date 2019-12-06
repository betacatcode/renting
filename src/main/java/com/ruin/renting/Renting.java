package com.ruin.renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author ruin
 * @date 2019/10/31-14:23
 */

//@EnableAutoConfiguration(exclude = {
//        SecurityAutoConfiguration.class
//})
@SpringBootApplication
public class Renting {

    public static void main(String[] args) {
        SpringApplication.run(com.ruin.renting.Renting.class, args);
    }

}
