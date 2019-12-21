package com.ruin.renting.service.impl;

import com.ruin.renting.config.Data;
import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.dao.MsgRepository;
import com.ruin.renting.dao.RoleRepository;
import com.ruin.renting.dao.SysUserRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.Msg;
import com.ruin.renting.domain.SysRole;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.UserService;
import com.ruin.renting.utils.AvatarUtil;
import com.ruin.renting.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

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
    AvatarUtil avatarUtil;

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
    public String getUsernameById(Integer id) {
        return sysUserRepository.findById(id).get().getUsername();
    }

    @Override
    public SysUser getUserById(Integer id) {
        return sysUserRepository.findById(id).get();
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
    public Msg saveMsg(String senderName, String receiverName, String content) {
        Date date=new Date(System.currentTimeMillis());
        SysUser sender=sysUserRepository.findByUsername(senderName);
        SysUser receiver=sysUserRepository.findByUsername(receiverName);
        Msg msg=new Msg(sender,receiver,content,date);
        msgRepository.save(msg);
        return msg;
    }

    @Override
    public List<SysUser> findContactUsers() {
        Integer userId=userInfo.getCurrentUser().getId();
        List<SysUser> users=new ArrayList<>();
        List<Integer> contactsIds = msgRepository.getContactsId(userId);
        for(Integer contactsId:contactsIds){
            SysUser user=sysUserRepository.findById(contactsId).get();
            users.add(user);
        }
        return users;
    }

    @Override
    public List<Msg> getChatInformation(Integer userId,Integer contactId) {
        return msgRepository.getChatInformation(userId,contactId);
    }

    @Override
    public void updateUser(MultipartFile avatar, String username, String profile, String email, String phone) {
        Integer userID=userInfo.getCurrentUser().getId();
        SysUser user=sysUserRepository.findById(userID).get();

        if(!avatar.getOriginalFilename().equals("")){
            String imgName = avatarUtil.saveNewsImage(avatar, username);
            user.setAvatar(imgName);
        }
        user.setUsername(username);
        user.setProfile(profile);
        user.setEmail(email);
        user.setPhone(phone);

        sysUserRepository.save(user);
    }

    @Override
    public void updateUser(Integer userID,MultipartFile avatar, String username, String profile, String email, String phone, String password) {
        SysUser user=sysUserRepository.findById(userID).get();
        if(!avatar.getOriginalFilename().equals("")){
            String img=avatarUtil.saveNewsImage(avatar,username);
            user.setAvatar(img);
        }
        if(!username.equals("")){
            user.setUsername(username);
        }
        user.setProfile(profile);
        user.setEmail(email);
        user.setPhone(phone);
        if(!password.equals("")){
            String hashPWD = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(hashPWD);
        }

        sysUserRepository.save(user);
    }

    @Override
    public void updateUser(String password) {
        Integer userID=userInfo.getCurrentUser().getId();
        SysUser user=sysUserRepository.findById(userID).get();
        String hashPWD = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hashPWD);

        sysUserRepository.save(user);
    }

    @Override
    public SysUser findByUserID(Integer ID) {
        return sysUserRepository.findById(ID).get();
    }

    @Override
    public List<SysUser> findAllUsers() {
        return sysUserRepository.findAll();
    }

    @Override
    public Page<SysUser> findAllUsersPaging(Pageable pageable) {
        return sysUserRepository.findAll(pageable);
    }

    @Override
    public void addUser(String username, String phone,String email, String password, String profile, MultipartFile avatar) {
        String hashPWD = BCrypt.hashpw(password, BCrypt.gensalt());

        SysUser user=new SysUser();
        user.setUsername(username);
        user.setPhone(phone);
        user.setEmail(email);
        user.setProfile(profile);
        user.setPassword(hashPWD);
        if(avatar.getOriginalFilename().equals(""))
            user.setAvatar("no");
        else {
            String img=avatarUtil.saveNewsImage(avatar,username);
            user.setAvatar(img);
        }

        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        sysUserRepository.save(user);
    }

    @Override
    public Integer deleteUserByID(Integer ID) {

        SysUser user=sysUserRepository.findById(ID).get();
        user.getRoles().clear();
        if(!user.getAvatar().equals("no")){
            avatarUtil.deleteFile(Data.path+"\\avatar\\"+user.getAvatar());
        }
        sysUserRepository.delete(user);
        return 200;
    }

    @Override
    public Page<SysUser> findUsernameLike(String name, Pageable pageable) {
        return sysUserRepository.findByUsernameLike("%"+name+"%",pageable);
    }
}
