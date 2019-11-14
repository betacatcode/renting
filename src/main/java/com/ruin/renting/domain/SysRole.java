package com.ruin.renting.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author ruin
 * @date 2019/10/27-15:23
 */

@Entity
@Table(name="tb_sys_role")
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
