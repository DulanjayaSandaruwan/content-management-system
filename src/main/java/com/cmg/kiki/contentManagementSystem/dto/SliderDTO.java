package com.cmg.kiki.contentManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderDTO {
    public int id;
    private String genre;
    private String title;
    private int orderNo;
    private String deviceType;
    private Date startDate;
    private Date endDate;
    private int userId;

}
