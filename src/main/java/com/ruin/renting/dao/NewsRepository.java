package com.ruin.renting.dao;

import com.ruin.renting.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruin
 * @date 2019/11/13-11:00
 */
public interface NewsRepository extends JpaRepository<News,Integer> {
}
