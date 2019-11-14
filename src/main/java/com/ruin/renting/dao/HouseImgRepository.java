package com.ruin.renting.dao;

import com.ruin.renting.domain.HouseImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/5-17:14
 */
public interface HouseImgRepository extends JpaRepository<HouseImg,Integer>{

    @Query(value = "SELECT * FROM tb_house_imgs WHERE id >= " +
            "((SELECT MAX(id) FROM tb_house_imgs)-(SELECT MIN(id) FROM tb_house_imgs)) * RAND()\n" +
            " + (SELECT MIN(id) FROM tb_house_imgs) limit ?1",nativeQuery=true)
    public List<HouseImg> getRandomImages(Integer num);
}
