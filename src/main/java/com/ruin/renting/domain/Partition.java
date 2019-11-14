package com.ruin.renting.domain;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "partition",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<News> news;

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

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
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
