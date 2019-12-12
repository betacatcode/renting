package com.ruin.renting.service;

import com.ruin.renting.domain.House;

import java.util.Set;

/**
 * @author ruin
 * @date 2019/12/9-20:22
 */
public interface UserService {
    public Integer findUserByUsername(String username);

    public void doRegister(String phone,String email,String username,
                           String password);

    public Integer collectHouse(Integer houseId);

    public Integer cancelCollect(Integer houseId);

    public boolean hasCollected(Integer houseId);

    public Set<House> findUserCollectHouses();

    public void saveMsg(String senderName,String receiverName,String content);
}
