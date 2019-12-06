package com.ruin.renting.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * @author ruin
 * @date 2019/10/27-15:18
 */
@Entity
@Table(name="tb_sys_user")
public class SysUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String avatar;
    private String profile;

    @ManyToMany(targetEntity = SysRole.class,cascade = CascadeType.ALL)
    @JoinTable(name = "tb_sys_user_roles",
        joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "roles_id",referencedColumnName = "id")})
    private Set<SysRole> roles=new HashSet<>();

//    用户收藏的房子 多对多的关系 用户可以收藏多个房子 每个房子也能被多个用户收藏
    @ManyToMany(targetEntity =House.class)
    @JoinTable(name= "tb_sys_user_collect_houses",
        joinColumns = {@JoinColumn(name="users_id",referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name="houses_id",referencedColumnName = "id")})
    private Set<House> collectHouses=new HashSet<>();

//    用户拥有的房子 一对多的关系 并且支持级联操作
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<House> ownHouses=new HashSet<>();

    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL)
    private Set<Comment> commentList=new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
        Set<SysRole> roles=this.getRoles();
        for(SysRole role:roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public Set<House> getCollectHouses() {
        return collectHouses;
    }

    public void setCollectHouses(Set<House> collectHouses) {
        this.collectHouses = collectHouses;
    }

    public Set<House> getOwnHouses() {
        return ownHouses;
    }

    public void setOwnHouses(Set<House> ownHouses) {
        this.ownHouses = ownHouses;
    }

    public Set<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(Set<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles=" + roles +
                '}';
    }
}
