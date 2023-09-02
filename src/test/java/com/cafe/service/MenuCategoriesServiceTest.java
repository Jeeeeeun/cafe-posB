package com.cafe.service;

import com.cafe.domain.MenuCategoriesVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Log4j2
public class MenuCategoriesServiceTest {

    @Setter(onMethod_ = @Autowired)
    private MenuCategoriesService menuCatsService;

    @Test
    @Disabled
    public void getMenuCategoriesTest() {
        MenuCategoriesVO menuCatsVO = new MenuCategoriesVO();

        List<MenuCategoriesVO> menuCatLists = menuCatsService.getMenuCategories(menuCatsVO);

        log.info("메뉴 카테고리 목록 서비스까지 잘 가져왔지? - " + menuCatLists);

        assertNotNull(menuCatLists);
    }

}
