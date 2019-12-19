package com.ruin.renting.web;

import com.ruin.renting.domain.Partition;
import com.ruin.renting.service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author ruin
 * @date 2019/12/19-17:03
 */

@Controller
public class PartitionController {

    @Autowired
    PartitionService partitionService;

    @RequestMapping("/addPartition")
    public String addPartition(String name){
        Partition p=new Partition(name,0);
        partitionService.savePartition(p);
        return "redirect:/back/partitionManage";
    }

    @RequestMapping("/getPartitionByID")
    @ResponseBody
    public Partition getPartitionByID(Integer ID){
        return partitionService.findPartitionByID(ID);
    }

    @RequestMapping("/updatePartition")
    public String updatePartition(Integer id,String name){
        partitionService.updatePartition(id,name);
        return "redirect:/back/partitionManage";
    }

    @RequestMapping("/deletePartitionByID")
    @ResponseBody
    public Integer deletePartitionByID(Integer ID){
        return partitionService.deletePartitionByID(ID);
    }
}
