package com.ruin.renting.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ruin
 * @date 2019/11/12-19:16
 */

@Entity
@Table(name="tb_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Date pubTime;
    private String img;
    private Integer commentNum;

    @OneToMany(mappedBy = "news",cascade= CascadeType.ALL)
    private Set<Comment> commentList=new HashSet<>();

    @ManyToMany(targetEntity = Tag.class)
    @JoinTable(name = "tb_tag_news",
        joinColumns={@JoinColumn(name = "news_id",referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name="tags_id",referencedColumnName = "id")})
    private Set<Tag> tags=new HashSet<>();

    @ManyToOne(targetEntity = Partition.class)
    @JoinColumn(name = "news_partition_id",referencedColumnName = "id")
    private Partition partition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Set<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(Set<Comment> commentList) {
        this.commentList = commentList;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Partition getPartition() {
        return partition;
    }

    public void setPartition(Partition partition) {
        this.partition = partition;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pubTime=" + pubTime +
                ", commentList=" + commentList +
                ", tags=" + tags +
                ", partition=" + partition +
                '}';
    }
}
