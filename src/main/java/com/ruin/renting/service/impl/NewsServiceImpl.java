package com.ruin.renting.service.impl;

import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.dao.NewsRepository;
import com.ruin.renting.dao.PartitionRepository;
import com.ruin.renting.dao.TagRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.Set;

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
    public Page<News> findAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public Set<News> findNewsByPartition(String name) {
        return partitionRepository.findPartitionByName(name).getNews();
    }

    @Override
    public Set<News> findNewsByTag(String name) {
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

    @Override
    public List<News> findRandomNews() {
        return newsRepository.findRandomNews();
    }

    @Override
    public void saveNews(News news, MultipartFile file) {
        if(file==null)
            news.setImg("default.jpg");

        news.setCommentNum(0);
        news.setPubTime(new Date(System.currentTimeMillis()));
        System.out.println(news);
        newsRepository.save(news);
    }

    @Override
    public void deleteNews(Integer id) {
        News news=newsRepository.findById(id).get();
        newsRepository.delete(news);
    }

    @Override
    public Page<News> findByTitleLike(String title,Pageable pageable) {
        return newsRepository.findByTitleLike("%"+title+"%", pageable);
    }

    @Override
    public void updateNews(News news, MultipartFile file) {
        newsRepository.save(news);
    }

}
