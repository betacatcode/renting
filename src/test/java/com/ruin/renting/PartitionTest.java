package com.ruin.renting;

import com.ruin.renting.service.PartitionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ruin
 * @date 2019/12/19-16:52
 */
@SpringBootTest
public class PartitionTest {

    @Autowired
    PartitionService partitionService;

    @Test
    public void partitionStatistics(){
        partitionService.partitionStatistics();
    }
}
