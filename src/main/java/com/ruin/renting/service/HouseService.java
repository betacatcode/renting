package com.ruin.renting.service;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ruin
 * @date 2019/11/2-18:52
 */
public interface HouseService {
    public Page<House> findAllHouses(Pageable pageable);

    public Page<House> findByAllCriteria(String subwayline, String mode, String orientation, String item,
                                         String term, Integer minPrice, Integer maxPrice, Pageable pageable);

    public House findByName(String name);

    public SysUser findOwner(House house);

    public List<HouseImg> recommend(int colNum);

    public Page<House> findHighPriceHouses();

    public List<House> findHighPerformanceHouses();

    public void addHouse(House house,Integer userID);

    public void deleteById(Integer id);

    public House findByID(Integer id);

    public void updateHouse(House house,Integer userID);

    public Page<House> findByNameLike(String name,Pageable pageable);

    public Page<House> findByNameLikeByOwner(String name,SysUser user,Pageable pageable);

    public List<HouseImg> findHouseImgById(Integer id);

    public void updateImg(Integer id,HttpServletRequest request);

    public void updateVideo(Integer id,MultipartFile video);

    public Page<House> findHouseByOwner(SysUser user,Pageable pageable);



}
