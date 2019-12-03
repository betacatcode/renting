package com.ruin.renting.service.impl;

import com.ruin.renting.dao.TagRepository;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:29
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> findRandomTags() {
        return tagRepository.findRandomTags();
    }
}
