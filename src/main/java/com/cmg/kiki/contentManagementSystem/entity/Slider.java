package com.cmg.kiki.contentManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@JsonIgnoreType
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "slider")
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private int id;

    @Column(name = "background_image")
    private String backgroundImage;

    @Column(name = "genre")
    private String genre;

    @Column(name = "genre_status")
    private String genreStatus;

    @Column(name = "description")
    private String description;

    @Column(name = "main_button")
    private String mainButton;

    @Column(name = "sub_button")
    private String subButton;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "order_no", columnDefinition = "TINYINT")
    private int orderNo;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "create_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "update_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "status", columnDefinition = "TINYINT")
    private int status;

    @Column(name = "user_id", columnDefinition = "BIGINT")
    private int userId;

}
