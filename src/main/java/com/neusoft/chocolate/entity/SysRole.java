package com.neusoft.chocolate.entity;

import javax.persistence.*;

@Entity
@Table(name="sys_role")
public class SysRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    private SysUser sysUser;//角色对应的用户实体

    @Column(name="name",length=100)
    private String name;//角色名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
