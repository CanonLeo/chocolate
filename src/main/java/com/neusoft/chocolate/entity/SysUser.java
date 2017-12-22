package com.neusoft.chocolate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", length = 120)
    private String name; //用户名
    @Column(name = "email", length = 50)
    private String email;//用户邮箱
    @Column(name = "password", length = 120)
    private String password;//用户密码
    @Temporal(TemporalType.DATE)
    @Column(name = "time", length = 10)
    private Date time;//时间

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sysUser")
    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

    public SysUser(String name, String email, String password, Date time, Set<SysRole> sysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.time = time;
        SysRoles = sysRoles;
    }

    public SysUser() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sysUser")
    public Set<SysRole> getSysRoles() {
        return SysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        SysRoles = sysRoles;
    }
}
