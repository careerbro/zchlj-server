package com.main.careerbro.modules.comment.entity;

import lombok.Getter;
import lombok.Setter;

public class Comment {
    @Getter @Setter private String id;
    @Getter @Setter private String userId;
    @Getter @Setter private String name;
    @Getter @Setter private String salaryId;
    @Getter @Setter private String contend;
    @Getter @Setter private String time;
    @Getter @Setter private Integer agreeNum;
}
