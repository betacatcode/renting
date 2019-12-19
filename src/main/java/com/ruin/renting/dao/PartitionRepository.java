package com.ruin.renting.dao;

import com.ruin.renting.domain.Partition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:35
 */
public interface PartitionRepository extends JpaRepository<Partition,Integer> {
    public Partition findByName(String name);

    @Query(value = "SELECT news_partition_id as pid,count(*) as num from \n" +
            "tb_news GROUP BY news_partition_id",nativeQuery = true)
    public List<Object[]>findEveryPartitionNum();
}
