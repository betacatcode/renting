package com.ruin.renting.service;

import com.ruin.renting.domain.Partition;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:35
 */
public interface PartitionService {
    public List<Partition> findAllPartitions();

    public Partition findPartitionByName(String name);

    public void partitionStatistics();

    public void savePartition(Partition p);

    public Partition findPartitionByID(Integer id);

    public void updatePartition(Integer id,String name);

    public Integer deletePartitionByID(Integer id);

}
