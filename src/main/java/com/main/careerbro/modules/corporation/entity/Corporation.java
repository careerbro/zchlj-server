package com.main.careerbro.modules.corporation.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Corporation implements Serializable {
    @Getter @Setter private String id;
    @Getter @Setter private String city;
    @Getter @Setter private String eName;
    @Getter @Setter private String cName;
    @Getter @Setter private String sName;
}
