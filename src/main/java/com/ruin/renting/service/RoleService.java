package com.ruin.renting.service;

import com.ruin.renting.domain.SysRole;

/**
 * @author ruin
 * @date 2019/12/9-21:13
 */
public interface RoleService {

    public SysRole findRoleByName(String name);
}
