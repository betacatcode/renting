package com.ruin.renting.web;

import com.ruin.renting.dao.HouseImgRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
    public String addHouse(House house){
        houseService.addHouse(house);
        return "redirect:/back/houseManage";
    }

    @RequestMapping("/updateHouse")
    public String updateHouse(House house){
        houseService.updateHouse(house);
        return "redirect:/back/houseManage";
    }

    @RequestMapping("/back/findByHouseNameLike")
    public String findByHouseNameLike(String name, Model model,@RequestParam(defaultValue = "0") Integer pageNum){
        Page<House> houses = houseService.findByNameLike(name, PageRequest.of(pageNum, 10));

        model.addAttribute("houses",houses);
        model.addAttribute("type","query");
        model.addAttribute("name",name);
        return "/back/houseManage";
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
    public String updateImg(Integer id,HttpServletRequest request){
        houseService.updateImg(id,request);
        return "redirect:/back/houseManage";
    }

    @RequestMapping("/back/updateVideo")
    public String updateVideo(Integer id,MultipartFile video){
        houseService.updateVideo(id,video);
        return "redirect:/back/houseManage";
    }

}
