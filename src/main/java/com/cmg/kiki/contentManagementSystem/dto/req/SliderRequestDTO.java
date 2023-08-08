package com.cmg.kiki.contentManagementSystem.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderRequestDTO {
    public int id;
    private String backgroundImage;
    private String genre;
    private String genreStatus;
    private String description;
    private String mainButton;
    private String subButton;
    private String title;
    private int orderNo;
    private String deviceType;
    private Date startDate;
    private Date endDate;
    private int userId;
}
