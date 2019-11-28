package com.ruin.renting.service;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

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

    public void addHouse(House house);

    public void deleteById(Integer id);

    public House findByID(Integer id);

    public void updateHouse(House house);

    public Page<House> findByNameLike(String name,Pageable pageable);

    public List<HouseImg> findHouseImgById(Integer id);

    public void updateImg(Integer id,HttpServletRequest request);
}
