package com.ruin.renting.service;

import com.ruin.renting.domain.Tag;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:29
 */
public interface TagService {
    public List<Tag> findAllTags();

    public List<Tag> findRandomTags();

    public Tag findTagByName(String name);
}
