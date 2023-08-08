package com.cmg.kiki.contentManagementSystem.dto.res;

import com.cmg.kiki.contentManagementSystem.dto.SliderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderPaginationResponseDTO {
    private List<SliderDTO> sliderDTOs;
    private int count;
}
