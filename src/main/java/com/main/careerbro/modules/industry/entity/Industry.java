package com.main.careerbro.modules.industry.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Industry implements Serializable {
    @Getter @Setter private String id;
    @Getter @Setter private String eName;
    @Getter @Setter private String cName;
}
