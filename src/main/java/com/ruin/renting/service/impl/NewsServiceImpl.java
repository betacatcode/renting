package com.ruin.renting.service.impl;

import com.ruin.renting.dao.NewsRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-11:02
 */

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> findAllNews() {
        return newsRepository.findAll();
    }
}
