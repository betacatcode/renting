package com.ruin.renting.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author ruin
 * @date 2019/11/12-19:34
 */

@Entity
@Table(name="tb_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer num;

    @ManyToMany(mappedBy = "tags",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
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

}
