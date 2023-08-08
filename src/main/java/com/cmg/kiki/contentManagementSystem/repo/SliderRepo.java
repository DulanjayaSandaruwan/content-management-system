package com.cmg.kiki.contentManagementSystem.repo;

import com.cmg.kiki.contentManagementSystem.entity.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SliderRepo extends JpaRepository<Slider, Integer> {

    String GET_ALL_SLIDER_BY_STATUS_DEVICE_AND_ORDER_NO =
            "SELECT * FROM kiki_content_db.slider WHERE status = 1 and curdate() BETWEEN cast( start_date as Date) AND cast(end_date as Date) AND device_type=?1 ORDER BY order_no ASC;";
    String FIND_ALL_SLIDER_BY_STATUS =
            "SELECT * FROM kiki_content_db.slider WHERE status=:status limit :offset,:limit";
    String COUNT_BY_SLIDER_ID =
            "SELECT COUNT(id) FROM kiki_content_db.slider WHERE status=?1";
    String SEARCH_BY_KEYWORD =
            "SELECT * FROM kiki_content_db.slider WHERE CONCAT(id, genre, title, start_date, end_date, order_no, device_type, user_id) like %:keyword% AND status=:status limit :offset,:limit ;";

    @Query(value = GET_ALL_SLIDER_BY_STATUS_DEVICE_AND_ORDER_NO, nativeQuery = true)
    List<Slider> getAllSliders(String deviceType);

    @Query(value = FIND_ALL_SLIDER_BY_STATUS, nativeQuery = true)
    List<Slider> findAllByStatus(Integer limit, Integer offset, Integer status);

    @Query(value = COUNT_BY_SLIDER_ID, nativeQuery = true)
    int countBySliderId(int status);

    @Query(value = SEARCH_BY_KEYWORD, nativeQuery = true)
    List<Slider> searchByUsingKeyword(String keyword, Integer status, Integer limit, Integer offset);

}
