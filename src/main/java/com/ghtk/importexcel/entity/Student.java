package com.ghtk.importexcel.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student {
    private int stt;
    private String primarySchool;
    private String district;
    private String rollNumber;
    private String classStudent;
    private String name;
    private int day;
    private int month;
    private int year;
    private String gender;
    private String placeOfBirth;
    private String nation;
    private String permanentResidence;
    private String phoneNumber;
    private int grade1;
    private int grade2;
    private int grade3;
    private int grade4;
    private int grade5;
    private int gradeFinal;
    private int priorityPoint;
    private int totalPoint;
    private String note;
}
