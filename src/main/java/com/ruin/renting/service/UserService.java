package com.ruin.renting.service;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.Msg;
import com.ruin.renting.domain.SysUser;

import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/12/9-20:22
 */
public interface UserService {
    public Integer findUserByUsername(String username);

    public String getUsernameById(Integer id);

    public void doRegister(String phone,String email,String username,
                           String password);

    public Integer collectHouse(Integer houseId);

    public Integer cancelCollect(Integer houseId);

    public boolean hasCollected(Integer houseId);

    public Set<House> findUserCollectHouses();

    public Msg saveMsg(String senderName,String receiverName,String content);

    public List<SysUser> findContactUsers();

    public List<Msg> getChatInformation(Integer userId,Integer contactId);
}
