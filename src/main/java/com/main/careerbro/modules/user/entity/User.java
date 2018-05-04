package com.main.careerbro.modules.user.entity;

import lombok.Getter;
import lombok.Setter;

public class User {
//    id
    @Getter @Setter private String id;
//    openid
    @Getter @Setter private String openid;
//    nikeName
    @Getter @Setter private String petName;
//    email
    @Getter @Setter private String email;
//    school
    @Getter @Setter private String college;
//    photo_path
    @Getter @Setter private String photoPath;

    @Override
    public String toString(){
        return "id:"+this.id+"  openid:"+this.openid+"  petName:"+this.petName
                +"  email:"+this.email+"  college:"+this.college+"  photoPath:"+this.photoPath;
    }
}
