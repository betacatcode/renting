package com.ruin.renting.web;

import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/deleteTagByID")
    @ResponseBody
    public Integer deleteTagByID(Integer ID){
        return tagService.deleteTagByID(ID);
    }

    @RequestMapping("/addTag")
    public String addTag(String name){
        Tag tag=new Tag(name,0);
        tagService.saveTag(tag);
        return "redirect:/back/tagManage";
    }

    @RequestMapping("getTagByID")
    @ResponseBody
    public Tag getTagByID(Integer ID){
        return tagService.getTagByID(ID);
    }

    @RequestMapping("/updateTag")
    public String updateTag(Integer id,String name){
        tagService.updateTag(id,name);
        return "redirect:/back/tagManage";
    }

    @RequestMapping("/back/findTagNameLike")
    public String findByNewsTitleLike(String name, Model model, @RequestParam(defaultValue = "0") Integer pageNum){
        Page<Tag> tags = tagService.findByNameLike(name, PageRequest.of(pageNum, 10));

        model.addAttribute("tags",tags);
        model.addAttribute("name",name);
        model.addAttribute("type","query");
        return "/back/tagManage";
    }
}

