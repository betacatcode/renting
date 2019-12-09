package com.ruin.renting.service.impl;

import com.ruin.renting.dao.SysUserRepository;
import com.ruin.renting.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ruin
 * @date 2019/12/8-16:59
 */

@Service
public class CustomUserServiceImpl implements UserDetailsService{

    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user=userRepository.findByUsername(userName);
        System.out.println(user);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
