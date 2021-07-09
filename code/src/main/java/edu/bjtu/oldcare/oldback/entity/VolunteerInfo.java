package edu.bjtu.oldcare.oldback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "volunteer_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ORG_ID")
    private Integer orgId;

    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "checkin_date")
    private Date hireDate;

    @Column(name = "checkout_date")
    private Date resignDate;

    @Column(name = "imgset_dir")
    private String imgsetDir;

    @Column(name = "profile_photo")
    private String profilePhoto;

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
}
