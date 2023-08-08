package com.cmg.kiki.contentManagementSystem.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderResponseDTO {
    private String backgroundImage;
    private String genre;
    private String genreStatus;
    private String description;
    private String mainButton;
    private String subButton;
    private String title;
}
