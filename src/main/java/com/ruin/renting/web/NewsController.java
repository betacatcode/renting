package com.ruin.renting.web;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.NewsService;
import com.ruin.renting.service.PartitionService;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

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

        List<News> recommendNews=newsService.findRandomNews();
        model.addAttribute("recommendNews",recommendNews);
        newsService.findTagsAndPartitions(model);
        return "front/news/index";
    }

    @RequestMapping("/findNewsByPartition")
    public String findNewsByPartition(String name,Model model){
        Set<News> allNews = newsService.findNewsByPartition(name);
        model.addAttribute("allNews",allNews);

        newsService.findTagsAndPartitions(model);
        return "front/news/index";
    }

    @RequestMapping("/findNewsByTag")
    public String findNewsByTag(String name,Model model){
        Set<News> allNews=newsService.findNewsByTag(name);
        model.addAttribute("allNews",allNews);

        newsService.findTagsAndPartitions(model);
        return "front/news/index";
    }

    @RequestMapping("/single")
    public String goSingle(Model model,@RequestParam(defaultValue = "none") String title){
        if(title.equals("none"))
            return "redirect:/news";
        News news=newsService.findNewsByTitle(title);
        model.addAttribute("news",news);

        newsService.findTagsAndPartitions(model);
        return "front/news/single";
    }

    @RequestMapping("/back/findByNewsTitleLike")
    public String findByNewsTitleLike(String title, Model model,@RequestParam(defaultValue = "0") Integer pageNum){
        Page<News> newses = newsService.findByTitleLike(title, PageRequest.of(pageNum, 10));
        List<Partition> partitions=partitionService.findAllPartitions();

        model.addAttribute("newses",newses);
        model.addAttribute("partitions",partitions);
        model.addAttribute("type","query");
        model.addAttribute("title",title);
        return "/back/newsManage";
    }
}
