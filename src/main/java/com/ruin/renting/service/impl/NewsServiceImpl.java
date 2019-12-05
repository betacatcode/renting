package com.ruin.renting.service.impl;

import com.ruin.renting.config.Data;
import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.dao.NewsRepository;
import com.ruin.renting.dao.PartitionRepository;
import com.ruin.renting.dao.TagRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.NewsService;
import com.ruin.renting.utils.ImageUtil;
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

    @Autowired
    ImageUtil imageUtil;

    @Override
    public List<News> findAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News findNewsByID(Integer ID) {
        return newsRepository.findById(ID).get();
    }

    @Override
    public Page<News> findAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public Set<News> findNewsByPartition(String name) {
        return partitionRepository.findByName(name).getNews();
    }

    @Override
    public Set<News> findNewsByTag(String name) {
        return tagRepository.findByName(name).getNews();
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
    public void saveNews(String title, String content, MultipartFile file,String partition,String tags) {
        News news=new News();
        news.setTitle(title);
        news.setContent(content);
        news.setCommentNum(0);
        news.setPubTime(new Date(System.currentTimeMillis()));
        news.setPartition(partitionRepository.findByName(partition));

        String []allTag=tags.split(";");
        for(int i=0;i<allTag.length;i++){
            Tag findTag=tagRepository.findByName(allTag[i]);
            if(findTag==null){
                Tag tag=new Tag();
                tag.setName(allTag[i]);
                tag.setNum(0);
                tagRepository.save(tag);

                Tag newTag=tagRepository.findByName(allTag[i]);
                newTag.getNews().add(news);
                news.getTags().add(newTag);
            }else {
                findTag.getNews().add(news);
                news.getTags().add(findTag);
            }
        }
        newsRepository.save(news);

//        设置图片
        News thisNews=newsRepository.findByTitle(title);
        if(file.getOriginalFilename().equals("")){
            thisNews.setImg("default.jpg");
        }else {
            String imgName = imageUtil.saveNewsImage(file, thisNews.getId());
            thisNews.setImg(imgName);
        }
        newsRepository.save(news);
    }

    @Override
    public Integer deleteNews(Integer id) {
        News news=newsRepository.findById(id).get();
        newsRepository.delete(news);
        imageUtil.deleteFile(Data.path+"img\\"+news.getImg());
        return 200;
    }

    @Override
    public Page<News> findByTitleLike(String title,Pageable pageable) {
        return newsRepository.findByTitleLike("%"+title+"%", pageable);
    }

    @Override
    public void updateNews(Integer id,String title,String content,
                           MultipartFile file0,String partition,String tags) {
        News news=newsRepository.findById(id).get();
        news.setTitle(title);
        news.setContent(content);
        Partition p=partitionRepository.findByName(partition);
        news.setPartition(p);


        if(content.trim().equals("")) {
            news.getTags().clear();
        }else{
            String allTag[]=tags.split("\\s+");
            news.getTags().clear();
            for(int i=0;i<allTag.length;i++){
                Tag tag=tagRepository.findByName(allTag[i]);
//            如果是新的标签
                if(tag==null){
                    tag=new Tag(allTag[i],0);
                    tagRepository.save(tag);
                }
                news.getTags().add(tag);
            }
        }
        if(file0.getOriginalFilename().equals("")){
            news.setImg("default.jpg");
        }else
            imageUtil.saveNewsImage(file0,news.getId());
        newsRepository.save(news);

    }

}
