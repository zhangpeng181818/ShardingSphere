package com.nuc.zp.entity;

import lombok.Data;

@Data
public class Course {

    private Long id;

    private String courseName;

    private Long userId;

    private String courseStatus;
}
