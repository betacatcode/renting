package com.ruin.renting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ruin
 * @date 2019/10/27-16:25
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/back/houseManage").hasRole("ADMIN")
                .antMatchers("/back/newsManage").hasRole("ADMIN")
                .antMatchers("/back/tagManage").hasRole("ADMIN")
                .antMatchers("/details").authenticated()
                .antMatchers("/back/*").authenticated()
                .anyRequest().permitAll()
                .and()
//                允许表单登陆
                .formLogin()
                    .loginPage("/back/login")
                    .loginProcessingUrl("/back/doLogin")
//                自定义登陆成功的页面地址
                    .successForwardUrl("/back/index").permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/index").permitAll();
    }
}
