package com.ruin.renting.web;

import com.ruin.renting.dao.HouseImgRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import com.ruin.renting.service.UserService;
import com.ruin.renting.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ruin
 * @date 2019/11/2-18:56
 */


@Controller
public class HouseController {

    @Autowired
    HouseService houseService;

    @Autowired
    UserService userService;

    @Autowired
    UserInfo userInfo;

    @Value("4")
    int pageSize;

    @RequestMapping("/forrent")
    public String findByAllCriteria(@RequestParam(defaultValue = "0")int pageNum,@RequestParam(defaultValue = "unlimited")String subwayline,
                                    @RequestParam(defaultValue = "unlimited")String mode,@RequestParam(defaultValue = "unlimited") String orientation,
                                    @RequestParam(defaultValue = "unlimited")String item, @RequestParam(defaultValue = "unlimited")String term,
                                    @RequestParam(defaultValue = "0")Integer minPrice, @RequestParam(defaultValue = "99999")Integer maxPrice,Model model){
        Page<House> houses=houseService.findByAllCriteria(subwayline,mode,orientation,item,term,minPrice,maxPrice,
                PageRequest.of(pageNum,pageSize));
        model.addAttribute("houses",houses);
        int totalPages=houses.getTotalPages();
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("currentPage",pageNum);

        model.addAttribute("pageNum",pageNum);
        model.addAttribute("subwayline",subwayline);
        model.addAttribute("mode",mode);
        model.addAttribute("orientation",orientation);
        model.addAttribute("item",item);
        model.addAttribute("term",term);
        model.addAttribute("minPrice",minPrice);
        model.addAttribute("maxPrice",maxPrice);

        return "front/forrent";
    }

    @GetMapping("/details")
    public String getDetails(String name,Model model){
        House house=houseService.findByName(name);
        SysUser owner=houseService.findOwner(house);

        if(userService.hasCollected(house.getId()))
            model.addAttribute("hasCollected","true");
        else
            model.addAttribute("hasCollected","false");
        model.addAttribute("house",house);
        model.addAttribute("owner",owner);
        return "front/details";
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam(defaultValue = "2") int colNum,Model model){
        List<HouseImg> houseImgs=houseService.recommend(colNum*3);
        Map<String,List<HouseImg>> imgs=new HashMap<>();

        for(int i=0;i<3;i++){
            List<HouseImg> part=new ArrayList<>();
            for(int j=0;j<colNum;j++){
                part.add(houseImgs.get(i*colNum+j));
            }
            imgs.put("p"+i,part);
        }

        model.addAttribute("imgs",imgs);
        return "front/recommends/"+colNum+"col";
    }

    @GetMapping("/getRecommendHouse")
    public String getRecommendHouse(String houseImgName,Model model){
        String []splits=houseImgName.split("_");

        House house=houseService.findByName(splits[0]);
        SysUser owner=houseService.findOwner(house);

        model.addAttribute("house",house);
        model.addAttribute("owner",owner);
        return "front/details";
    }

    @GetMapping(value = {"/","/index"})
    public String index(Model model){

        Page<House> highPriceHouses = houseService.findHighPriceHouses();
        model.addAttribute("highPriceHouses",highPriceHouses);

        List<House> highPerformanceHouses = houseService.findHighPerformanceHouses();
        for(int i=0;i<2;i++){
            List<House> houses=new ArrayList<>();
            for(int j=0;j<2;j++)
                houses.add(highPerformanceHouses.get(i*2+j));
            model.addAttribute("hp"+i,houses);
        }

        return "front/index";
    }

    @RequestMapping("/deleteByID")
    @ResponseBody
    public String deleteById(Integer ID){

        houseService.deleteById(ID);
        return "200";
    }

    @RequestMapping("/getHouseByID")
    @ResponseBody
    public House getHouseByID(Integer ID){
        return houseService.findByID(ID);
    }

    @RequestMapping("/addHouse")
    public String addHouse(House house,String role,@RequestParam(defaultValue = "3")Integer userID){
        if(role.equals("admin")){
            houseService.addHouse(house,userID);
            return "redirect:/back/houseManage";
        }else {
            userID=userInfo.getCurrentUser().getId();
            houseService.addHouse(house,userID);
            return "redirect:/back/rentingHousesManage";
        }


    }

    @RequestMapping("/updateHouse")
    public String updateHouse(House house,String role,@RequestParam(defaultValue = "3")Integer userID){
        if(role.equals("admin")){
            houseService.updateHouse(house,userID);
            return "redirect:/back/houseManage";
        }else{
            userID=userInfo.getCurrentUser().getId();
            houseService.updateHouse(house,userID);
            return "redirect:/back/rentingHousesManage";
        }


    }

    @RequestMapping("/back/findByHouseNameLike")
    public String findByHouseNameLike(String name, Model model,@RequestParam(defaultValue = "0") Integer pageNum,String role){

        model.addAttribute("type","query");
        model.addAttribute("name",name);
        model.addAttribute("role",role);

        if(role.equals("admin")){
            Page<House> houses = houseService.findByNameLike(name, PageRequest.of(pageNum, 10));
            model.addAttribute("houses",houses);
            return "/back/admin/houseManage";
        }
        else{
            SysUser user=userService.findByUserID(userInfo.getCurrentUser().getId());
            Page<House> houses=houseService.findByNameLikeByOwner(name,user,PageRequest.of(pageNum, 10));
            model.addAttribute("houses",houses);
            return "/back/user/rentingHousesManage";
        }

    }

    @RequestMapping("/getHouseImgByID")
    @ResponseBody
    public List<HouseImg> getHouseImgByID(Integer ID){
        return houseService.findHouseImgById(ID);
    }

    @RequestMapping("/getHouseVideoByID")
    @ResponseBody
    public String getHouseVideoByID(Integer ID){
        return houseService.findByID(ID).getVideo();
    }

    @RequestMapping("/back/updateImg")
    public String updateImg(Integer id,HttpServletRequest request,String role){
        houseService.updateImg(id,request);
        if(role.equals("admin"))
            return "redirect:/back/houseManage";
        else
            return "redirect:/back/rentingHousesManage";
    }

    @RequestMapping("/back/updateVideo")
    public String updateVideo(Integer id,MultipartFile video,String role){
        houseService.updateVideo(id,video);
        if(role.equals("admin"))
            return "redirect:/back/houseManage";
        else
            return "redirect:/back/rentingHousesManage";

    }

}
