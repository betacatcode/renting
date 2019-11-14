package com.ruin.renting.service.impl;

import com.ruin.renting.dao.HouseImgRepository;
import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/2-18:55
 */

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    public HouseRepository houseRepository;

    @Autowired
    public HouseImgRepository houseImgRepository;

    @Override
    public Page<House> findAllHouses(Pageable pageable) {

        return houseRepository.findAll(pageable);
    }

    @Override
    public Page<House> findByAllCriteria(String subwayline, String mode, String orientation, String item,
                                         String term, Integer minPrice, Integer maxPrice, Pageable pageable) {
        if(subwayline.equals("unlimited"))
            subwayline="";
        if(mode.equals("unlimited"))
            mode="";
        if(orientation.equals("unlimited"))
            orientation="";
        if(item.equals("unlimited"))
            item="";
        if(term.equals("unlimited"))
            term="";
        Page<House> houses=houseRepository.findByAllCriteria(subwayline,mode,orientation,item,term,minPrice,maxPrice,pageable);
        return houses;
    }

    @Override
    public House findByName(String name) {
        return houseRepository.findByName(name);
    }

    @Override
    public SysUser findOwner(House house) {
        List<SysUser> users=house.getUsers();
        SysUser owner=users.get(0);

        for(SysUser user:users){
            if(user.getRoles().equals("ROLE_OWNER")){
                owner=user;
                break;
            }
        }
        return owner;
    }

    @Override
    public List<HouseImg> recommend(int colNum) {
        return houseImgRepository.getRandomImages(colNum);
    }
}
