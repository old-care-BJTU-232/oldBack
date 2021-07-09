package edu.bjtu.oldcare.oldback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ORG_ID")
    private Integer orgId;

    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "UserName")
    private String name;

    @Column(name = "Password")
    private String password;

    @Column(name = "REAL_NAME")
    private String realname;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ISACTIVE")
    private String isactive;

    @Column(name = "CREATED")
    private Date created;

    @Column(name = "CREATEBY")
    private Integer createby;

    @Column(name = "UPDATED")
    private Date updated;

    @Column(name = "UPDATEBY")
    private Integer updateby;

    @Column(name = "REMOVE")
    private String remove;

    @Column(name = "DATAFILTER")
    private String datafilter;

    @Column(name = "theme")
    private String theme;

    @Column(name = "defaultpage")
    private String defaultpage;

    @Column(name = "logoimage")
    private String logoimage;

    @Column(name = "qqopenid")
    private String qqopenid;

    @Column(name = "appversion")
    private String appversion;

    @Column(name = "jsonauth")
    private String jsonauth;
}
