package com.ruin.renting.dao;

import com.ruin.renting.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-11:00
 */
public interface NewsRepository extends JpaRepository<News,Integer> {
    public News findByTitle(String title);

    @Query(value = "SELECT * FROM tb_news WHERE " +
            "id >= ((SELECT MAX(id) FROM tb_news)-(SELECT MIN(id) FROM tb_news)) * RAND()\n" +
            "           + (SELECT MIN(id) FROM tb_news) limit 4",nativeQuery=true)
    public List<News> findRandomNews();
}
