package com.cafe.controller;

import com.cafe.domain.MenuCategoriesVO;
import com.cafe.service.MenuCategoriesService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@AllArgsConstructor
@RequestMapping("/")
@CrossOrigin(originPatterns = "*")
@Log4j2
public class MenuCategoriesController {

    @NonNull
    private MenuCategoriesService menuCategoriesService;

    @GetMapping("/api/getMenuCategories")
    public ResponseEntity<List<MenuCategoriesVO>> getMenuCategories(MenuCategoriesVO menuCategoriesVO) {

        try {
            List<MenuCategoriesVO> menuCategoryLists = menuCategoriesService.getMenuCategories(menuCategoriesVO);

            log.info("서비스 실행 완료 - " + menuCategoryLists);

            return ResponseEntity.ok(menuCategoryLists);


        } catch (Exception e) {

            log.info ("에러 - " + e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }
}