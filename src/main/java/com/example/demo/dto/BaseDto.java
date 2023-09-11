package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class BaseDto {
    private Long id;
    private String createdBy;
    private Date createdAt;
    private LocalDate localDate;
    private String updatedBy;
    private Date updateAt;
    private Integer activeStatus;
}
