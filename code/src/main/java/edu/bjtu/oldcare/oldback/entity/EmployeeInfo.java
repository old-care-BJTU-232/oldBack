package edu.bjtu.oldcare.oldback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ORG_ID")
    private Integer orgId;

    @Column(name = "CLIENT_ID")
    private Integer clientId;

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

    @Column(name = "hire_date")
    private Date hire_date;

    @Column(name = "resign_date")
    private Date resign_date;

    @Column(name = "imgset_dir")
    private String imgset_dir;

    @Column(name = "profile_photo")
    private String profile_photo;

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
