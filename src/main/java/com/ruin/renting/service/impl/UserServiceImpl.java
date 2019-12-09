package com.ruin.renting.service.impl;

import com.ruin.renting.dao.RoleRepository;
import com.ruin.renting.dao.SysUserRepository;
import com.ruin.renting.domain.SysRole;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author ruin
 * @date 2019/12/9-20:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Integer findUserByUsername(String username) {
        SysUser sysUser=sysUserRepository.findByUsername(username);
        if(sysUser==null)
            return 404;
        return 200;
    }

    @Override
    public void doRegister(String phone, String email, String username, String password) {
        String hashPWD = BCrypt.hashpw(password, BCrypt.gensalt());
        SysUser user=new SysUser(username,hashPWD,phone,email,"no","no");
        SysRole role=roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        sysUserRepository.save(user);
    }
}
