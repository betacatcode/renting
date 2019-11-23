package com.ruin.renting.service;

import com.ruin.renting.domain.News;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/13-11:01
 */
public interface NewsService {

    public List<News> findAllNews();

    public Set<News> findNewsByPartition(String name);

    public Set<News> findNewsByTag(String name);

    public News findNewsByTitle(String title);

    public void findTagsAndPartitions(Model model);

    public List<News> findRandomNews();
}
