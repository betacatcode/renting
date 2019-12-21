package com.ruin.renting.web;

import com.ruin.renting.domain.*;
import com.ruin.renting.service.*;
import com.ruin.renting.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import java.util.Collections;
import java.util.Comparator;
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

    @Autowired
    UserInfo userInfo;

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
        List<SysUser>users=userService.findAllUsers();

        model.addAttribute("users",users);
        model.addAttribute("houses",data);
        model.addAttribute("type","show");
        model.addAttribute("role","admin");
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

    @RequestMapping("/partitionManage")
    public String goPartitions(Model model){

        partitionService.partitionStatistics();
        List<Partition> allPartitions = partitionService.findAllPartitions();
        model.addAttribute("partitions",allPartitions);
        return "/back/admin/partitionManage";
    }

    @RequestMapping("/collectManage")
    public String goCollects(Model model){

        Set<House> houses = userService.findUserCollectHouses();
        model.addAttribute("houses",houses);
        return "/back/user/collectManage";
    }

    @RequestMapping("/rentingHousesManage")
    public String goRentingHouses(Model model,@RequestParam(defaultValue = "0")int pageNum){
        SysUser user=userService.findByUserID(userInfo.getCurrentUser().getId());
        Page<House> houses=houseService.findHouseByOwner(user,PageRequest.of(pageNum,10));
        model.addAttribute("role","user");
        model.addAttribute("houses",houses);
        model.addAttribute("type","show");
        return "/back/user/rentingHousesManage";
    }

    @RequestMapping("/chat")
    public String goChat(Model model,String receiverName){
        model.addAttribute("receiverName",receiverName);
        return "/back/user/chat";
    }

    @RequestMapping("/message")
    public String goMessage(Model model){
        model.addAttribute("userID",userInfo.getCurrentUser().getId());
        return "/back/user/message";
    }

    @RequestMapping("/findContactUsers")
    @ResponseBody
    public List<SysUser> findContactUsers(){
        List<SysUser> contactUsers = userService.findContactUsers();
        return contactUsers;
    }

    @RequestMapping("/getChatInformation")
    @ResponseBody
    public List<Msg> getChatInformation(Integer userID,Integer contactID){
        List<Msg> chatInformation = userService.getChatInformation(userID, contactID);
        return chatInformation;
    }

    @RequestMapping("/profile")
    public String goProfile(Model model){
        model.addAttribute("user",userService.getUserById(userInfo.getCurrentUser().getId()));
        return "/back/user/profile";
    }

    @RequestMapping("/userManage")
    public String goUser(Model model,@RequestParam(defaultValue = "0")int pageNum){
        Page<SysUser> users = userService.findAllUsersPaging(PageRequest.of(pageNum, 10));
        model.addAttribute("users",users);
        model.addAttribute("type","show");
        return "/back/admin/userManage";
    }


}
