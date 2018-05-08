package com.main.careerbro.modules.attention.entity;

import lombok.Getter;
import lombok.Setter;

public class Attention {
    @Getter @Setter private String id;
    @Getter @Setter private String userId;
    @Getter @Setter private String user;
    @Getter @Setter private String attendId;
    @Getter @Setter private String attend;
    @Getter @Setter private Integer category;
    @Getter @Setter private String time;
}
