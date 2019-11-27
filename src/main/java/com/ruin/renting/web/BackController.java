package com.ruin.renting.web;

import com.ruin.renting.domain.House;
import com.ruin.renting.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ruin
 * @date 2019/11/26-15:47
 */

@Controller
@RequestMapping("back")
public class BackController {

    @Autowired
    HouseService houseService;

    @RequestMapping("/index")
    public String goIndex(){
        return "/back/index";
    }

    @RequestMapping("/houseManage")
    public String goHouse(Model model,@RequestParam(defaultValue = "0")int pageNum) {
        Page<House> data=houseService.findAllHouses(PageRequest.of(pageNum,15));
        model.addAttribute("houses",data.getContent());
        return "/back/houseManage";
    }


}
