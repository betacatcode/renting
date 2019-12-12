package com.ruin.renting.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ruin
 * @date 2019/10/27-15:59
 */

@Entity
@Table(name = "tb_msg")
public class Msg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private SysUser sender;

    @OneToOne
    private SysUser receiver;
    private String content;
    private Date sendingTime;

    public SysUser getSender() {
        return sender;
    }

    public void setSender(SysUser sender) {
        this.sender = sender;
    }

    public SysUser getReceiver() {
        return receiver;
    }

    public void setReceiver(SysUser receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Date sendingTime) {
        this.sendingTime = sendingTime;
    }

    public Msg() {
    }

    public Msg(SysUser sender, SysUser receiver, String content, Date sendingTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sendingTime = sendingTime;
    }
}
