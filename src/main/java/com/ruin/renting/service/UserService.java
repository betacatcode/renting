package com.ruin.renting.service;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.Msg;
import com.ruin.renting.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/12/9-20:22
 */
public interface UserService {
    public Integer findUserByUsername(String username);

    public String getUsernameById(Integer id);

    public SysUser getUserById(Integer id);

    public void doRegister(String phone,String email,String username,
                           String password);

    public Integer collectHouse(Integer houseId);

    public Integer cancelCollect(Integer houseId);

    public boolean hasCollected(Integer houseId);

    public Set<House> findUserCollectHouses();

    public Msg saveMsg(String senderName,String receiverName,String content);

    public List<SysUser> findContactUsers();

    public List<Msg> getChatInformation(Integer userId,Integer contactId);

    public void updateUser(MultipartFile avatar, String username, String profile, String email, String phone);

    public void updateUser(Integer userID,MultipartFile avatar, String username, String profile, String email, String phone,String password);

    public void updateUser(String password);

    public SysUser findByUserID(Integer ID);

    public List<SysUser> findAllUsers();

    public Page<SysUser> findAllUsersPaging(Pageable pageable);

    public void addUser(String username,String phone,String email,String password,String profile,MultipartFile avatar);

    public Integer deleteUserByID(Integer ID);

    public Page<SysUser> findUsernameLike(String name,Pageable pageable);
}
