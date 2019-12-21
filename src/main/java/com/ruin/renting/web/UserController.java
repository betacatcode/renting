package com.ruin.renting.web;

import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.SysRole;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import com.ruin.renting.service.UserService;
import com.ruin.renting.utils.HttpClientPostFs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("/updateUser")
    public String updateUser(MultipartFile avatar,String username,String profile,String email,String phone,
                             String password1){
        if(password1.equals("")){
            userService.updateUser(avatar,username,profile,email,phone);
        }else{
            userService.updateUser(password1);
        }

        return "redirect:/back/profile";
    }

    @RequestMapping("/updateUserByAdmin")
    public String updateUserByAdmin(Integer userID,MultipartFile avatar,String username,String profile,String email,String phone,
                                    String password){
        userService.updateUser(userID,avatar,username,profile,email,phone,password);
        return "redirect:/back/userManage";
    }

    @RequestMapping("/addUser")
    public String addUser(String username,String phone,String email,String password,String profile,MultipartFile avatar){
        userService.addUser(username,phone,email,password,profile,avatar);
        return "redirect:/back/userManage";
    }

    @RequestMapping("/getUserByID")
    @ResponseBody
    public SysUser getUserByID(Integer ID){
        return userService.findByUserID(ID);
    }

    @RequestMapping("/deleteUserByID")
    @ResponseBody
    public Integer deleteUserByID(Integer ID){
        return userService.deleteUserByID(ID);
    }

    @RequestMapping("/back/findUserNameLike")
    public String findUserNameLike(Model model,String name, @RequestParam(defaultValue = "0") Integer pageNum){

        Pageable pageable= PageRequest.of(pageNum,10);
        Page<SysUser> users = userService.findUsernameLike(name, pageable);
        model.addAttribute("users",users);
        model.addAttribute("name",name);
        model.addAttribute("type","query");

        return "/back/admin/userManage";
    }

}
