package com.ruin.renting.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/2-16:09
 */

@Entity
@Table(name="tb_house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String profile;
    private String video;
    private String apartment;
    private Float size;
    private String subwayline;
    private String mode;
    private String orientation;
    private String item;
    private String term;
    private Integer price;

    @JsonIgnore
    @OneToMany(mappedBy = "house",cascade=CascadeType.ALL)
    private Set<HouseImg> houseImgList=new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "collectHouses")
    private Set<SysUser> collectUsers=new HashSet<>();

    @ManyToOne(targetEntity = SysUser.class)
    @JoinColumn(name="owner_id",referencedColumnName = "id")
    private SysUser owner;

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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getSubwayline() {
        return subwayline;
    }

    public void setSubwayline(String subwayline) {
        this.subwayline = subwayline;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<HouseImg> getHouseImgList() {
        return houseImgList;
    }

    public void setHouseImgList(Set<HouseImg> houseImgList) {
        this.houseImgList = houseImgList;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public SysUser getOwner() {
        return owner;
    }

    public void setOwner(SysUser owner) {
        this.owner = owner;
    }

    public Set<SysUser> getCollectUsers() {
        return collectUsers;
    }

    public void setCollectUsers(Set<SysUser> collectUsers) {
        this.collectUsers = collectUsers;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", video='" + video + '\'' +
                ", apartment='" + apartment + '\'' +
                ", size=" + size +
                ", subwayline='" + subwayline + '\'' +
                ", mode='" + mode + '\'' +
                ", orientation='" + orientation + '\'' +
                ", item='" + item + '\'' +
                ", term='" + term + '\'' +
                ", price=" + price +
                ", houseImgList=" + houseImgList +
                ", users=" + collectUsers +
                '}';
    }
}
