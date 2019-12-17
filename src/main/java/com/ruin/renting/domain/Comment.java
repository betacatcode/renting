package com.ruin.renting.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToOne(targetEntity = News.class)
    @JoinColumn(name="comment_news_id",referencedColumnName = "id")
    private News news;


    @ManyToOne(targetEntity = SysUser.class )
    @JoinColumn(name="comment_user_id",referencedColumnName = "id")
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

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}
