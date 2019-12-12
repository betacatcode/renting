package com.ruin.renting.dao;

import com.ruin.renting.domain.Msg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruin
 * @date 2019/12/12-13:04
 */
public interface MsgRepository extends JpaRepository<Msg,Integer> {
}
