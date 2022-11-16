package com.fty1.example.log.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Data
@ToString
public  class User {

    private static final long serialVersionUID = -4004643361026020655L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @Column(name = "real_name")
    private String realName;


    @Column(name = "id_no")
    private String idCardNo;



}