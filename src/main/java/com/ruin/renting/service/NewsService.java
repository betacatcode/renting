package com.ruin.renting.service;

import com.ruin.renting.domain.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/13-11:01
 */
public interface NewsService {

    public List<News> findAllNews();

    public Page<News> findAllNews(Pageable pageable);

    public Set<News> findNewsByPartition(String name);

    public Set<News> findNewsByTag(String name);

    public News findNewsByTitle(String title);

    public void findTagsAndPartitions(Model model);

    public List<News> findRandomNews();

    public void saveNews(News news, MultipartFile file);

    public void deleteNews(Integer id);

    public Page<News> findByTitleLike(String name,Pageable pageable);

    public void updateNews(News news,MultipartFile file);

}
