package com.ruin.renting.dao;

import com.ruin.renting.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruin
 * @date 2019/11/13-19:28
 */
public interface TagRepository extends JpaRepository<Tag,Integer>{

    public Tag findTagByName(String name);
}


