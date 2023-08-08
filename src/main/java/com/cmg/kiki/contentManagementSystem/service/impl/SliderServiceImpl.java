package com.cmg.kiki.contentManagementSystem.service.impl;

import com.cmg.kiki.contentManagementSystem.dto.SliderDTO;
import com.cmg.kiki.contentManagementSystem.dto.req.SliderRequestDTO;
import com.cmg.kiki.contentManagementSystem.dto.res.SliderPaginationResponseDTO;
import com.cmg.kiki.contentManagementSystem.dto.res.SliderResponseDTO;
import com.cmg.kiki.contentManagementSystem.entity.Slider;
import com.cmg.kiki.contentManagementSystem.repo.SliderRepo;
import com.cmg.kiki.contentManagementSystem.service.SliderService;
import com.cmg.kiki.contentManagementSystem.util.CommonUtil;
import com.cmg.kiki.contentManagementSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SliderServiceImpl implements SliderService {

    @Autowired
    private SliderRepo sliderRepo;

    @Override
    public ResponseUtil saveOrUpdateSlider(SliderRequestDTO sliderRequestDTO) {
        if (sliderRequestDTO.id != 0) {
            Optional<Slider> existSlider = sliderRepo.findById(sliderRequestDTO.getId());
            if (existSlider.isPresent()) {
                existSlider.get().setBackgroundImage(sliderRequestDTO.getBackgroundImage());
                existSlider.get().setGenre(sliderRequestDTO.getGenre());
                existSlider.get().setGenreStatus(sliderRequestDTO.getGenreStatus());
                existSlider.get().setDescription(sliderRequestDTO.getDescription());
                existSlider.get().setMainButton(sliderRequestDTO.getMainButton());
                existSlider.get().setSubButton(sliderRequestDTO.getSubButton());
                existSlider.get().setTitle(sliderRequestDTO.getTitle());
                existSlider.get().setOrderNo(sliderRequestDTO.getOrderNo());
                existSlider.get().setDeviceType(sliderRequestDTO.getDeviceType());
                existSlider.get().setUserId(sliderRequestDTO.getUserId());
                existSlider.get().setStartDate(sliderRequestDTO.getStartDate());
                existSlider.get().setEndDate(sliderRequestDTO.getEndDate());
                existSlider.get().setStatus(CommonUtil.ACTIVE);
                existSlider.get().setUpdateDate(new Date());
                sliderRepo.save(existSlider.get());
            } else {
                return null;
            }
        } else {
            Slider newSlider = new Slider();
            newSlider.setBackgroundImage(sliderRequestDTO.getBackgroundImage());
            newSlider.setGenreStatus(sliderRequestDTO.getGenreStatus());
            newSlider.setDescription(sliderRequestDTO.getDescription());
            newSlider.setMainButton(sliderRequestDTO.getMainButton());
            newSlider.setSubButton(sliderRequestDTO.getSubButton());
            newSlider.setTitle(sliderRequestDTO.getTitle());
            newSlider.setOrderNo(sliderRequestDTO.getOrderNo());
            newSlider.setDeviceType(sliderRequestDTO.getDeviceType());
            newSlider.setUserId(sliderRequestDTO.getUserId());
            newSlider.setStartDate(sliderRequestDTO.getStartDate());
            newSlider.setEndDate(sliderRequestDTO.getEndDate());
            newSlider.setStatus(CommonUtil.ACTIVE);
            newSlider.setCreateDate(new Date());
            sliderRepo.save(newSlider);newSlider.setGenre(sliderRequestDTO.getGenre());

        }
        return new ResponseUtil(200, "Successfully Added / Updated A Slider", null);
    }

    @Override
    public List<SliderResponseDTO> getAllSliders(String deviceType) {
        List<SliderResponseDTO> sliderResponseDTO = new ArrayList<>();
        List<Slider> slider = sliderRepo.getAllSliders(deviceType);
        for (Slider sliders : slider) {
            SliderResponseDTO dto = new SliderResponseDTO();
            dto.setBackgroundImage(sliders.getBackgroundImage());
            dto.setGenre(sliders.getGenre());
            dto.setGenreStatus(sliders.getGenreStatus());
            dto.setDescription(sliders.getDescription());
            dto.setMainButton(sliders.getMainButton());
            dto.setSubButton(sliders.getSubButton());
            dto.setTitle(sliders.getTitle());
            sliderResponseDTO.add(dto);
        }
        return sliderResponseDTO;
    }

    @Override
    public SliderPaginationResponseDTO findSliderWithPagination(int limit, int offset, int status) {
        List<SliderDTO> sliderDTOs = new ArrayList<>();
        List<Slider> sliderList = sliderRepo.findAllByStatus(limit, offset, status);
        for (Slider obj : sliderList) {
            sliderDTOs.add(new SliderDTO(
                    obj.getId(),
                    obj.getGenre(),
                    obj.getTitle(),
                    obj.getOrderNo(),
                    obj.getDeviceType(),
                    obj.getStartDate(),
                    obj.getEndDate(),
                    obj.getUserId()
            ));
        }
        return new SliderPaginationResponseDTO(sliderDTOs, sliderRepo.countBySliderId(status));
    }

    @Override
    public Boolean changeStatusOfUser(int sliderId) {
        Optional<Slider> slider = sliderRepo.findById(sliderId);
        if (slider.isPresent()) {
            slider.get().setStatus(CommonUtil.IN_ACTIVE);
            slider.get().setUpdateDate(new Date());
            sliderRepo.save(slider.get());
        }
        return true;
    }

    @Override
    public List<SliderDTO> searchSliderByUsingKeyword(String keyword, int status, int limit, int offset) {
        List<SliderDTO> sliderDTOs = new ArrayList<>();
        if (keyword != null) {
            List<Slider> objects = sliderRepo.searchByUsingKeyword(keyword, status, limit, offset);
            for (Slider obj : objects) {
                sliderDTOs.add(new SliderDTO(
                        obj.getId(),
                        obj.getGenre(),
                        obj.getTitle(),
                        obj.getOrderNo(),
                        obj.getDeviceType(),
                        obj.getStartDate(),
                        obj.getEndDate(),
                        obj.getUserId()
                ));
            }
        }
        return sliderDTOs;
    }

    @Override
    public SliderRequestDTO searchSliderBySliderId(int sliderId) {
        if (sliderRepo.existsById(sliderId)) {
            Optional<Slider> slider = sliderRepo.findById(sliderId);
            return new SliderRequestDTO(
                    slider.get().getId(),
                    slider.get().getBackgroundImage(),
                    slider.get().getGenre(),
                    slider.get().getGenreStatus(),
                    slider.get().getDescription(),
                    slider.get().getMainButton(),
                    slider.get().getSubButton(),
                    slider.get().getTitle(),
                    slider.get().getOrderNo(),
                    slider.get().getDeviceType(),
                    slider.get().getStartDate(),
                    slider.get().getEndDate(),
                    slider.get().getUserId()
            );

        } else {
            throw new RuntimeException("Search Failed, No Menu Available For " + sliderId);
        }
    }


}