package com.ruin.renting.service.impl;

import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.dao.MsgRepository;
import com.ruin.renting.dao.RoleRepository;
import com.ruin.renting.dao.SysUserRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.Msg;
import com.ruin.renting.domain.SysRole;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.UserService;
import com.ruin.renting.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/12/9-20:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    MsgRepository msgRepository;

    @Autowired
    UserInfo userInfo;

    @Override
    public Integer findUserByUsername(String username) {
        SysUser sysUser=sysUserRepository.findByUsername(username);
        if(sysUser==null)
            return 404;
        return 200;
    }

    @Override
    public void doRegister(String phone, String email, String username, String password) {
        String hashPWD = BCrypt.hashpw(password, BCrypt.gensalt());
        SysUser user=new SysUser(username,hashPWD,phone,email,"no","no");
        SysRole role=roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        sysUserRepository.save(user);
    }

    @Override
    public Integer collectHouse(Integer houseId) {
        Integer userId=userInfo.getCurrentUser().getId();

        SysUser user=sysUserRepository.findById(userId).get();
        House house= houseRepository.findById(houseId).get();

        user.getCollectHouses().add(house);
        sysUserRepository.save(user);

        return 200;
    }

    @Override
    public Integer cancelCollect(Integer houseId) {
        Integer userId=userInfo.getCurrentUser().getId();
        SysUser user=sysUserRepository.findById(userId).get();

        Iterator<House> it= user.getCollectHouses().iterator();
        while(it.hasNext()){
            if(it.next().getId()==houseId){
                it.remove();
            }
        }
        sysUserRepository.save(user);
        return 200;
    }

    @Override
    public boolean hasCollected(Integer houseId) {
        Integer userId=userInfo.getCurrentUser().getId();
        if(sysUserRepository.IfUserCollectHouse(userId,houseId)>0)
            return true;
        return false;
    }

    @Override
    public Set<House> findUserCollectHouses() {
        Integer userId=userInfo.getCurrentUser().getId();
        SysUser user=sysUserRepository.findById(userId).get();
        return user.getCollectHouses();
    }

    @Override
    public void saveMsg(String senderName, String receiverName, String content) {
        Date date=new Date(System.currentTimeMillis());
        SysUser sender=sysUserRepository.findByUsername(senderName);
        SysUser receiver=sysUserRepository.findByUsername(receiverName);
        Msg msg=new Msg(sender,receiver,content,date);
        msgRepository.save(msg);
    }
}
