package com.ruin.renting.web;

import com.ruin.renting.dao.HouseImgRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
