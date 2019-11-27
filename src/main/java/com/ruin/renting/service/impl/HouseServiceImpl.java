package com.ruin.renting.service.impl;

import com.ruin.renting.dao.HouseImgRepository;
import com.ruin.renting.dao.HouseRepository;
import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import com.ruin.renting.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Set;

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
        Page<House> houses=houseRepository.findBySubwaylineLikeAndModeLikeAndOrientationLikeAndItemLikeAndTermLikeAndPriceGreaterThanEqualAndPriceLessThanEqual
                ("%"+subwayline+"%","%"+mode+"%","%"+orientation+"%",
                        "%"+item+"%","%"+term+"%",minPrice,maxPrice,pageable);
        return houses;
    }

    @Override
    public House findByName(String name) {
        return houseRepository.findByName(name);
    }

    @Override
    public SysUser findOwner(House house) {
        Set<SysUser> users=house.getUsers();
        SysUser owner = null;
        if(users!=null&&users.size()>0) {
            owner=users.iterator().next();
        }

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

    @Override
    public Page<House> findHighPriceHouses() {
        Pageable pageable=PageRequest.of(0,4,Sort.by(Sort.Order.desc("price")));
        Page<House> houses= houseRepository.findAll(pageable);
        return houses;
    }

    @Override
    public List<House> findHighPerformanceHouses() {
        return houseRepository.findHighPerformanceHouses();
    }

    @Override
    public void addHouse(House house) {
        house.setVideo("no");
        for(int i=1;i<=4;i++){
            HouseImg houseImg=new HouseImg();
            houseImg.setName("default.jpg");
            houseImg.setHouse(house);
            house.getHouseImgList().add(houseImg);
        }
        houseRepository.save(house);

    }

    @Override
    public void deleteById(Integer id) {
        houseRepository.deleteById(id);
    }

    @Override
    public House findByID(Integer id) {
        return houseRepository.findById(id).get();
    }

    @Override
    public void updateHouse(House house) {
        houseRepository.save(house);
    }

    @Override
    public Page<House> findByNameLike(String name,Pageable pageable) {
        return houseRepository.findByNameLike("%"+name+"%",pageable);
    }

    @Override
    public Set<HouseImg> findHouseImgById(Integer ID) {
        House house=findByID(ID);
        Set<HouseImg> imgs=house.getHouseImgList();
        return imgs;
    }


}
