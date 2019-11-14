package com.ruin.renting.web;

import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.NewsService;
import com.ruin.renting.service.PartitionService;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/7-20:33
 */
@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    TagService tagService;

    @Autowired
    PartitionService partitionService;

    @RequestMapping("/news")
    public String goNews(Model model){
        List<News> allNews = newsService.findAllNews();
        model.addAttribute("allNews",allNews);

        newsService.findTagsAndPartitions(model);
        return "front/news/index";
    }

    @RequestMapping("/findNewsByPartition")
    public String findNewsByPartition(String name,Model model){
        List<News> allNews = newsService.findNewsByPartition(name);
        model.addAttribute("allNews",allNews);

        newsService.findTagsAndPartitions(model);
        return "front/news/index";
    }

    @RequestMapping("/findNewsByTag")
    public String findNewsByTag(String name,Model model){
        List<News> allNews=newsService.findNewsByTag(name);
        model.addAttribute("allNews",allNews);

        newsService.findTagsAndPartitions(model);
        return "front/news/index";
    }

}
