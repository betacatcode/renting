package com.ruin.renting.dao;

import com.ruin.renting.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruin
 * @date 2019/10/27-16:02
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer>{

    SysUser findByUsername(String username);
}
