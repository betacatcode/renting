package com.ruin.renting.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ruin
 * @date 2019/11/26-15:47
 */

@Controller
@RequestMapping("back")
public class BackController {

    @RequestMapping("/index")
    public String goIndex(){
        return "/back/index";
    }

    @RequestMapping("/houseManage")
    public String goHouse() {
        return "/back/houseManage";
    }
}
