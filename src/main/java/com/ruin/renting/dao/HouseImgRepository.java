package com.ruin.renting.dao;

import com.ruin.renting.domain.HouseImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/5-17:14
 */
@Mapper
@Repository
public interface HouseImgRepository {

    @Select("SELECT * FROM tb_house_imgs WHERE id >= " +
            "((SELECT MAX(id) FROM tb_house_imgs)-(SELECT MIN(id) FROM tb_house_imgs)) * RAND()\n" +
            " + (SELECT MIN(id) FROM tb_house_imgs) limit #{num}")
    public List<HouseImg> getRandomImages(@Param("num")Integer num);
}
