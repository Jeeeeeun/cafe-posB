package com.cafe.controller;

import com.cafe.domain.MenuToOptionVO;
import com.cafe.service.MenuToOptionService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(originPatterns = "*")
@Log4j2
public class MenuToOptionController {

    @NonNull
    private MenuToOptionService menuToOptionService;

    @GetMapping("/api/getAllMenusWithOptions")
    public ResponseEntity<List<MenuToOptionVO>> takeAllMenusWithOptions() {
        List<MenuToOptionVO> allMenusWithOptions = menuToOptionService.getAllMenuWithOptions();
        log.info("데이터 잘 불러왔어? - " + allMenusWithOptions);
        return ResponseEntity.status(HttpStatus.OK).body(allMenusWithOptions);
    }
}
