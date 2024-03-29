package com.ruin.renting.dao;

import com.ruin.renting.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/13-19:28
 */
public interface TagRepository extends JpaRepository<Tag,Integer>{

    public Tag findByName(String name);

    @Query(value = "select * from tb_tag order by rand() limit 3",nativeQuery = true)
    public List<Tag> findRandomTags();

    @Query(value="SELECT tags_id,count(*) sum from tb_tag_news GROUP BY tags_id",nativeQuery = true)
    public List<Object[]> findEveryTagNum();

    public Page<Tag> findByNameLike(String name, Pageable pageable);

}


