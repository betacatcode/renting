package com.ruin.renting.utils;

import com.ruin.renting.domain.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author ruin
 * @date 2019/12/10-14:39
 */
@Component
public class UserInfo {

    public SysUser getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser currentUser=(SysUser) principal;
        return currentUser;
    }
}
