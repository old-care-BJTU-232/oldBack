package edu.bjtu.oldcare.oldback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "oldperson_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OldpersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    //表示一对多：  一个老人有多个事件记录对象： list
//    @OneToMany(mappedBy = "clz",fetch = FetchType.EAGER) //mapperBy 创建一对多的映射关系： 值是对方外键对应的属性名称。
//    @OneToMany(mappedBy = "old") //mapperBy 创建一对多的映射关系： 值是对方外键对应的属性名称。
//    private List<EventInfo> eventInfoList;


    @Column(name = "ORG_ID")
    private Integer ORG_ID;

    @Column(name = "CLIENT_ID")
    private Integer CLIENT_ID;

    @Column(name = "username")
    private String username;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "id_card")
    private String id_card;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "checkin_date")
    private Date checkin_date;

    @Column(name = "checkout_date")
    private Date checkout_date;

    @Column(name = "imgset_dir")
    private String imgset_dir;

    @Column(name = "profile_photo")
    private String profile_photo;

    @Column(name = "room_number")
    private String room_number;

    @Column(name = "firstguardian_name")
    private String firstguardian_name;

    @Column(name = "firstguardian_relationship")
    private String firstguardian_relationship;

    @Column(name = "firstguardian_phone")
    private String firstguardian_phone;

    @Column(name = "firstguardian_wechat")
    private String firstguardian_wechat;

    @Column(name = "secondguardian_name")
    private String secondguardian_name;

    @Column(name = "secondguardian_relationship")
    private String secondguardian_relationship;

    @Column(name = "secondguardian_phone")
    private String secondguardian_phone;

    @Column(name = "secondguardian_wechat")
    private String secondguardian_wechat;

    @Column(name = "health_state")
    private String health_state;

    @Column(name = "DESCRIPTION")
    private String DESCRIPTION;

    @Column(name = "ISACTIVE")
    private String ISACTIVE;

    @Column(name = "CREATED")
    private Date CREATED;

    @Column(name = "CREATEBY")
    private Integer CREATEBY;

    @Column(name = "UPDATED")
    private Date UPDATED;

    @Column(name = "UPDATEBY")
    private Integer UPDATEBY;

    @Column(name = "REMOVE")
    private String REMOVE;
}
