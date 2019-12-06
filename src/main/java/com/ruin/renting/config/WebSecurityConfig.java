package com.ruin.renting.config;

import com.ruin.renting.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ruin
 * @date 2019/10/27-16:25
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/",
//                        "/jquery/**",
//                        "/semantic/**",
//                        "/css/**",
//                        "/js/**",
//                        "/images/**",
//                        "/fonts/**",
//                        "/**/favicon.ico",
//                        "/**").permitAll()
//
            .anyRequest()
//                .authenticated()
//            .and()
//
//            .formLogin()
//                .loginPage("/back/login")
//                .loginProcessingUrl("/doLogin")
//                .failureUrl("/back/login")
//                .defaultSuccessUrl("/index")
//                .permitAll()
//
//            .and()
//            .logout()
                .permitAll();
    }
}
