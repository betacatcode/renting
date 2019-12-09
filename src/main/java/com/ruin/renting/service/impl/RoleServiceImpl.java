package com.ruin.renting.service.impl;

import com.ruin.renting.dao.RoleRepository;
import com.ruin.renting.domain.SysRole;
import com.ruin.renting.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ruin
 * @date 2019/12/9-21:14
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public SysRole findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
