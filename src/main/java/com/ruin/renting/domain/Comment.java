package com.ruin.renting.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ruin
 * @date 2019/11/12-19:31
 */
@Entity
@Table(name="tb_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date pubTime;
    private String content;

    @ManyToOne(cascade={CascadeType.ALL},optional=false)
    @JoinColumn(name="newsid")
    private News news;

    @ManyToOne(cascade={CascadeType.ALL},optional=false)
    @JoinColumn(name="userid")
    private SysUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
