package com.ruin.renting.service.impl;

import com.ruin.renting.dao.PartitionRepository;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:36
 */

@Service
public class PartitionServiceImpl implements PartitionService {

    @Autowired
    PartitionRepository partitionRepository;
    @Override
    public List<Partition> findAllPartitions() {
        return partitionRepository.findAll();
    }


}
