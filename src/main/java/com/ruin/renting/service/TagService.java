package com.ruin.renting.service;

import com.ruin.renting.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:29
 */
public interface TagService {
    public Page<Tag> findAllTags(Pageable pageable);

    public List<Tag> findRandomTags();

    public Tag findTagByName(String name);

    public void labelStatistics();

    public Integer deleteTagByID(Integer ID);

    public void saveTag(Tag tag);

    public Tag getTagByID(Integer id);

    public void updateTag(Integer id,String name);

    public Page<Tag> findByNameLike(String name,Pageable pageable);
}
