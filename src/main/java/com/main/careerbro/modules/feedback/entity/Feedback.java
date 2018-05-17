package com.main.careerbro.modules.feedback.entity;

import lombok.Getter;
import lombok.Setter;

public class Feedback {
    @Getter @Setter private String id;
    @Getter @Setter private String userId;
    @Getter @Setter private String contend;
    @Getter @Setter private String fTime;
    @Getter @Setter private String category;
    @Getter @Setter private String contact;
}
