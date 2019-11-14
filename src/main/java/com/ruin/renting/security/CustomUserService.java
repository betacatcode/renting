package com.ruin.renting.security;

import com.ruin.renting.dao.SysUserRepository;
import com.ruin.renting.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author ruin
 * @date 2019/10/27-16:07
 */

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user=userRepository.findByUsername(username);
        System.out.println(user);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

}
