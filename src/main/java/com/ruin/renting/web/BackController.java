package com.ruin.renting.web;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/26-15:47
 */

@EnableWebSecurity
@Controller
@RequestMapping("/back")
public class BackController {

    @Autowired
    HouseService houseService;

    @Autowired
    NewsService newsService;

    @Autowired
    PartitionService partitionService;

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String goIndex(){
        return "/back/index";
    }

    @RequestMapping("/login")
    public String goLogin(){
        return "/back/login";
    }
    @RequestMapping("/houseManage")
    public String goHouse(Model model,@RequestParam(defaultValue = "0")int pageNum) {
        Page<House> data=houseService.findAllHouses(PageRequest.of(pageNum,10));
        model.addAttribute("houses",data);
        model.addAttribute("type","show");
        return "/back/admin/houseManage";
    }

    @RequestMapping("/newsManage")
    public String goNews(Model model,@RequestParam(defaultValue = "0")int pageNum) {
        Page<News> data=newsService.findAllNews(PageRequest.of(pageNum,10));
        List<Partition> partitions=partitionService.findAllPartitions();

        model.addAttribute("partitions",partitions);
        model.addAttribute("newses",data);
        model.addAttribute("type","show");
        return "/back/admin/newsManage";
    }

    @RequestMapping("/tagManage")
    public String goTags(Model model,@RequestParam(defaultValue = "0")int pageNum){

        tagService.labelStatistics();
        Page<Tag> tags=tagService.findAllTags(PageRequest.of(pageNum,10));
        model.addAttribute("tags",tags);
        model.addAttribute("type","show");
        return "/back/admin/tagManage";
    }

    @RequestMapping("/collectManage")
    public String goCollects(Model model){

        Set<House> houses = userService.findUserCollectHouses();
        model.addAttribute("houses",houses);
        return "/back/user/collectManage";
    }

    @RequestMapping("/chat")
    public String goChat(Model model,String receiverName){
        model.addAttribute("receiverName",receiverName);
        return "/back/user/chat";
    }

    @RequestMapping("/message")
    public String goMessage(){
        return "/back/user/blank";
    }
}
