package com.ruin.renting.dao;

import com.ruin.renting.domain.Partition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruin
 * @date 2019/11/13-19:35
 */
public interface PartitionRepository extends JpaRepository<Partition,Integer> {
}
