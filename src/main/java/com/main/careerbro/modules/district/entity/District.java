package com.main.careerbro.modules.district.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class District implements Serializable {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String parentID;
    @Getter
    @Setter
    private String name;

}
