package com.ruin.renting.dao;

import com.ruin.renting.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruin
 * @date 2019/12/9-21:12
 */
public interface RoleRepository extends JpaRepository<SysRole,Integer> {

    public SysRole findByName(String name);
}
