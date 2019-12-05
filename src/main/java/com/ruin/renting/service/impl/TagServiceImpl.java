package com.ruin.renting.service.impl;

import com.ruin.renting.dao.TagRepository;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/13-19:29
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Page<Tag> findAllTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> findRandomTags() {
        return tagRepository.findRandomTags();
    }

    @Override
    public Tag findTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public void labelStatistics() {
        List<Object[]> objects=tagRepository.findEveryTagNum();
        for(Object o[]:objects){
            Tag tag=tagRepository.findById((Integer) o[0]).get();
            tag.setNum(Integer.valueOf(o[1].toString()));
            tagRepository.save(tag);
        }
    }

    @Transactional
    @Override
    public Integer deleteTagByID(Integer ID) {
        Tag tag=tagRepository.findById(ID).get();
        Set<News> newses = tag.getNews();
        for(News news:newses)
            news.getTags().remove(tag);
        tagRepository.delete(tag);
        return 200;
    }

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public Tag getTagByID(Integer id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public void updateTag(Integer id, String name) {
        Tag tag=tagRepository.findById(id).get();
        tag.setName(name);
        tagRepository.save(tag);
    }

    @Override
    public Page<Tag> findByNameLike(String name, Pageable pageable) {
        return tagRepository.findByNameLike("%"+name+"%",pageable);
    }
}
