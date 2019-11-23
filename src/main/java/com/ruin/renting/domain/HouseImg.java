package com.ruin.renting.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author ruin
 * @date 2019/11/2-16:33
 */


@Entity
@Table(name="tb_house_imgs")
public class HouseImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(targetEntity = House.class)
    @JoinColumn(name="img_house_id",referencedColumnName = "id")
    private House house;

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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "HouseImg{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
