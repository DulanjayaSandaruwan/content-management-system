package com.cmg.kiki.contentManagementSystem.service;

import com.cmg.kiki.contentManagementSystem.dto.SliderDTO;
import com.cmg.kiki.contentManagementSystem.dto.req.SliderRequestDTO;
import com.cmg.kiki.contentManagementSystem.dto.res.SliderPaginationResponseDTO;
import com.cmg.kiki.contentManagementSystem.dto.res.SliderResponseDTO;
import com.cmg.kiki.contentManagementSystem.util.ResponseUtil;

import java.util.List;

public interface SliderService {

    ResponseUtil saveOrUpdateSlider(SliderRequestDTO sliderRequestDTO);

    List<SliderResponseDTO> getAllSliders(String deviceType);

    SliderPaginationResponseDTO findSliderWithPagination(int limit, int offset, int status);

    Boolean changeStatusOfUser(int sliderId);

    List<SliderDTO> searchSliderByUsingKeyword(String keyword, int status, int limit, int offset);

    SliderRequestDTO searchSliderBySliderId(int sliderId);

}
