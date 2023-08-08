package com.cmg.kiki.contentManagementSystem.controller;

import com.cmg.kiki.contentManagementSystem.dto.req.SliderRequestDTO;
import com.cmg.kiki.contentManagementSystem.service.SliderService;
import com.cmg.kiki.contentManagementSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("slider")
@RestController
@CrossOrigin
public class SliderController {

    @Autowired
    SliderService sliderService;

    @PostMapping("/addOrUpdateSlider")
    public ResponseUtil addOrUpdateSlider(@RequestBody SliderRequestDTO sliderRequestDTO) {
        try {
            return sliderService.saveOrUpdateSlider(sliderRequestDTO);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @GetMapping("/allSliders/{deviceType}")
    public ResponseUtil getAllSliders(@PathVariable String deviceType) {
        try {
            return new ResponseUtil(200, "Data search successfully", sliderService.getAllSliders(deviceType));
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @GetMapping("/allSlidersWithPagination")
    public ResponseUtil getAllMenu(@RequestParam(value = "limit", required = true) Integer limit,
                                   @RequestParam(value = "offset", required = true) Integer offset,
                                   @RequestParam(value = "status", required = true) Integer status) {
        try {
            return new ResponseUtil(200, "Done", sliderService.findSliderWithPagination(limit, offset, status));
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @DeleteMapping("/changeStatusOfSlider/{sliderId}")
    public ResponseUtil changeStatusOfSlider(@PathVariable int sliderId) {
        try {
            return new ResponseUtil(200, "Successfully Change Slider's status", sliderService.changeStatusOfUser(sliderId));
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @GetMapping("/searchByKeyword")
    public ResponseUtil searchByKeyword(@RequestParam(value = "keyword", required = true) String keyword,
                                        @RequestParam(value = "status", required = true) Integer status,
                                        @RequestParam(value = "limit", required = true) Integer limit,
                                        @RequestParam(value = "offset", required = true) Integer offset) {
        try {
            return new ResponseUtil(200, "Done", sliderService.searchSliderByUsingKeyword(keyword, status, limit, offset));
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @GetMapping("/searchSliderBySliderId/{sliderId}")
    public ResponseUtil searchSliderBySliderId(@PathVariable String sliderId) {
        try {
            return new ResponseUtil(200, "Done", sliderService.searchSliderBySliderId(Integer.parseInt(sliderId)));
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

}
