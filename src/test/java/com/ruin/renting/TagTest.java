package com.ruin.renting;

import com.ruin.renting.dao.TagRepository;
import com.ruin.renting.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ruin
 * @date 2019/12/5-9:11
 */
@SpringBootTest
public class TagTest {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagService tagService;

    @Test
    public void findEveryTagNum(){
        List<Object[]> objects=tagRepository.findEveryTagNum();

        for(Object[] o:objects){
            System.out.println("tagId:"+o[0]);
            System.out.println("tagNum:"+o[1]);
        }

    }

    @Test
    public void labelStatistics(){
        tagService.labelStatistics();
    }
}
