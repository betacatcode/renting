package com.ruin.renting.dao;

import com.ruin.renting.domain.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/2-18:51
 */
public interface HouseRepository extends JpaRepository<House,Integer> {

//    @Query("select h from House h where" +
//            " h.subwayline like CONCAT('%',:subwayline,'%') and h.mode like CONCAT('%',:mode,'%') and" +
//            " h.orientation like CONCAT('%',:orientation,'%') and h.item like CONCAT('%',:item,'%') and " +
//            "h.term like CONCAT('%',:term,'%') and h.price>=:minPrice and h.price<=:maxPrice")
//    public Page<House> findByAllCriteria(@Param("subwayline")String subwayline, @Param("mode")String mode,
//                                         @Param("orientation")String orientation, @Param("item")String item,
//                                         @Param("term")String term, @Param("minPrice")Integer minPrice,
//                                         @Param("maxPrice")Integer maxPrice, Pageable pageable);

    public Page<House> findBySubwaylineLikeAndModeLikeAndOrientationLikeAndItemLikeAndTermLikeAndPriceGreaterThanEqualAndPriceLessThanEqual(
            String subwayline, String mode, String orientation, String item,
            String term, Integer minPrice, Integer maxPrice, Pageable pageable);

    public House findByName(String name);

    public Page<House> findAll(Pageable pageable);

    @Query(value = "SELECT * from tb_house ORDER BY size/price DESC LIMIT 4",nativeQuery=true)
    public List<House> findHighPerformanceHouses();

}
