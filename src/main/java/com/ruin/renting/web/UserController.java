package com.ruin.renting.web;

import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.SysRole;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import com.ruin.renting.service.UserService;
import com.ruin.renting.utils.HttpClientPostFs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ruin
 * @date 2019/12/9-20:51
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HttpClientPostFs http;

    @GetMapping("/checkUser")
    @ResponseBody
    public Integer checkUser(String username){
        return userService.findUserByUsername(username);
    }

    @RequestMapping("/register")
    public void register(String phone,String email,String username,
                           String password,HttpServletResponse response) throws IOException {
        userService.doRegister(phone,email,username,password);
        String url="/back/doLogin";
        http.setResponse(response);
        http.setParameter("username",username);
        http.setParameter("password",password);
        http.sendByPost(url);
    }

    @RequestMapping("/collect")
    @ResponseBody
    public Integer collect(Integer id){
        return userService.collectHouse(id);
    }

    @RequestMapping("/cancelCollect")
    @ResponseBody
    public Integer cancelCollect(Integer id){
        return userService.cancelCollect(id);
    }
}
