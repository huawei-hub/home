package com.hua.se.enums;

public enum Subject {
    MATH(1,"数学"),
    PHILOLOGY(2,"语文"),
    ENGLISH(3, "英语"),;
    private int code;
    private String discipline;

    Subject(int code, String discipline) {
        this.code = code;
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }
}
