package com.main.careerbro.modules.salary.entity;

import lombok.Getter;
import lombok.Setter;

public class Salary {
    @Getter @Setter private String id;
    @Getter @Setter private String job;
    @Getter @Setter private String jobId;
    @Getter @Setter private String user;
    @Getter @Setter private String college;
    @Getter @Setter private String industry;
    @Getter @Setter private String corporation;
    @Getter @Setter private String corporationId;
    @Getter @Setter private String city;
    @Getter @Setter private String cityId;
    @Getter @Setter private float yearSalaryMax;
    @Getter @Setter private float yearSalaryMin;
    @Getter @Setter private float monthSalary;
    @Getter @Setter private int monthNum;
    @Getter @Setter private String welfare;
    @Getter @Setter private String collegeLevel;
    @Getter @Setter private String eduBackGround;
    @Getter @Setter private String offerTime;
    @Getter @Setter private String experienceMonthNum;
    @Getter @Setter private int agreeNum;
    @Getter @Setter private int oppNum;
    @Getter @Setter private int graNum;
    @Getter @Setter private int shareNum;
    @Getter @Setter private int reserveNum;
    @Getter @Setter private double heatRate;
    @Getter @Setter private String createTime;
    @Getter @Setter private String updateTime;
    @Getter @Setter private int readNum;
}
