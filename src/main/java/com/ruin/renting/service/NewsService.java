package com.ruin.renting.service;

import com.ruin.renting.domain.News;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-11:01
 */
public interface NewsService {

    public List<News> findAllNews();

    public List<News> findNewsByPartition(String name);

    public List<News> findNewsByTag(String name);

    public void findTagsAndPartitions(Model model);
}
