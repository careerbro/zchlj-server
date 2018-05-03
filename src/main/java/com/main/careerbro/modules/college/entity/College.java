package com.main.careerbro.modules.college.entity;

import lombok.Getter;
import lombok.Setter;

public class College {
    @Getter @Setter private String id;
    @Getter @Setter private String city;
    @Getter @Setter private String cName;
    @Getter @Setter private String eName;
    @Getter @Setter private String sName;
    @Getter @Setter private String category; //类型
    @Getter @Setter private String publicPrivate; //公私立
    @Getter @Setter private String level;
    @Getter @Setter private String tag;
    @Getter @Setter private String website;
    @Getter @Setter private String photoPath;
}
