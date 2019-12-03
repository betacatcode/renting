package com.ruin.renting.web;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.HouseService;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ruin
 * @date 2019/12/3-20:33
 */

@Controller
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping("/back/getRandomTags")
    @ResponseBody
    public List<Tag> getRandomTags(){
        return tagService.findRandomTags();
    }

}

