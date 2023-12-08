package com.hua.se.enums;

public enum Gender {
    MAN(1,'男'),
    WOMAN(2, '女');

    private int code;
    private char gender;

    Gender(int code,char gender){
        this.code = code;
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }
}

