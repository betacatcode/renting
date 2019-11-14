package com.ruin.renting.service.impl;

import com.ruin.renting.dao.NewsRepository;
import com.ruin.renting.dao.PartitionRepository;
import com.ruin.renting.dao.TagRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-11:02
 */

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    PartitionRepository partitionRepository;

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<News> findAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> findNewsByPartition(String name) {
        return partitionRepository.findPartitionByName(name).getNews();
    }

    @Override
    public List<News> findNewsByTag(String name) {
        return tagRepository.findTagByName(name).getNews();
    }

    @Override
    public News findNewsByTitle(String title) {
        return newsRepository.findByTitle(title);
    }

    @Override
    public void findTagsAndPartitions(Model model) {
        List<Tag> tags=tagRepository.findAll();
        model.addAttribute("tags",tags);

        List<Partition> partitions=partitionRepository.findAll();
        model.addAttribute("partitions",partitions);
    }
}
