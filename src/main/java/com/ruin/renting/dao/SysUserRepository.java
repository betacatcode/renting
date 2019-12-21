package com.ruin.renting.dao;

import com.ruin.renting.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ruin
 * @date 2019/10/27-16:02
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer>{

    SysUser findByUsername(String username);

    Page<SysUser> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM tb_sys_user_collect_houses WHERE users_id=?1 AND houses_id=?2",nativeQuery = true)
    int IfUserCollectHouse(Integer userId,Integer houseId);

    Page<SysUser> findByUsernameLike(String name,Pageable pageable);
}
