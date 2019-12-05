package com.ruin.renting;

import com.ruin.renting.dao.NewsRepository;
import com.ruin.renting.dao.PartitionRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.NewsService;
import com.ruin.renting.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.util.List;

/**
 * @author ruin
 * @date 2019/12/3-13:27
 */

@SpringBootTest
public class NewsTest {

    @Autowired
    NewsService newsService;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    TagService tagService;

    @Test
    public void saveNews(){
        News news=new News();
        news.setTitle("test");
        news.setContent("测试内容");
//        newsService.saveNews(news,null);
    }



    @Test
    public void findByNameLike(){
        Page<News> newses = newsService.findByTitleLike("人", PageRequest.of(0, 10));
        List<News> content = newses.getContent();
        for (News n:content){
            System.out.println(n);
        }
    }

    @Test
    public void updateNews(){
        News news=newsRepository.findById(1).get();
        news.setPubTime(new Date(System.currentTimeMillis()));
//        newsService.saveNews(news,null);
    }

    @Test
    public void getRandomTags(){
        List<Tag> randomTags = tagService.findRandomTags();
        for(Tag tag:randomTags){
            System.out.println(tag);
        }
    }
}
