package com.ruin.renting.service.impl;

import com.ruin.renting.dao.PartitionRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    @Override
    public Partition findPartitionByName(String name) {
        return partitionRepository.findByName(name);
    }

    @Override
    public void partitionStatistics() {
        List<Object[]> objects=partitionRepository.findEveryPartitionNum();
        for(Object[] o:objects){
            Partition partition = partitionRepository.findById((Integer) o[0]).get();
            partition.setNum(Integer.valueOf(o[1].toString()));
            partitionRepository.save(partition);
        }
    }

    @Override
    public void savePartition(Partition p) {
        partitionRepository.save(p);
    }

    @Override
    public Partition findPartitionByID(Integer id) {
        return partitionRepository.findById(id).get();
    }

    @Override
    public void updatePartition(Integer id, String name) {
        Partition partition = partitionRepository.findById(id).get();
        partition.setName(name);
        partitionRepository.save(partition);
    }

    @Override
    public Integer deletePartitionByID(Integer id) {
        Partition p=partitionRepository.findById(id).get();
        Set<News>newsSet=p.getNews();
        for(News news:newsSet){
            if(news.getPartition().getName().equals(p.getName()))
                news.setPartition(null);
        }
        partitionRepository.deleteById(id);
        return 200;
    }


}
