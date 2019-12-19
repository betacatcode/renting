package com.ruin.renting.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/12-21:08
 */
@Entity
@Table(name="tb_partition")
public class Partition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer num;

    @OneToMany(mappedBy = "partition")
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"partition"})
    private Set<News> news=new HashSet<>();

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    public Partition() {
    }

    public Partition(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
