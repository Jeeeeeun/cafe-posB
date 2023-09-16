package com.cafe.controller;

import com.cafe.domain.MenusVO;
import com.cafe.service.MenusService;
import com.cafe.service.impl.MenusServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@AllArgsConstructor
@CrossOrigin(originPatterns = "*")
@Log4j2
public class MenusController {

    @NonNull
    private MenusService menusService;

    @NonNull
    private MenusServiceImpl menusServiceImpl;
    @PostMapping("/api/registerMenu")
    public ResponseEntity<String> registerMenu(@RequestBody MenusVO menusVO) {

        int addRow = menusServiceImpl.registerMenuIfValid(menusVO);

        String message;

        if (addRow == 0) {
            message = "메뉴 등록에 실패했습니다.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } else {
            message = "메뉴 등록에 성공했습니다.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
    }

    @GetMapping("/api/showAllMenus")
    public ResponseEntity<List<MenusVO>> showAllMenus() throws Exception {
            List<MenusVO> menuLists = menusService.getMenus();
            return ResponseEntity.status(HttpStatus.OK).body(menuLists);
    }

    @PostMapping("/api/checkSameMenuName")
    public boolean checkSameMenuName(@RequestBody MenusVO menusVO) {
        return menusService.isSameMenuName(menusVO.getMenu_name());
    }
}
