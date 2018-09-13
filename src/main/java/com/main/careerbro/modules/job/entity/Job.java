package com.main.careerbro.modules.job.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Job implements Serializable {
    @Getter @Setter private String id;
    @Getter @Setter private String cName;
    @Getter @Setter private String eName;
}
