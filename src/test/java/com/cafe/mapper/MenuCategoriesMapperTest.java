package com.cafe.mapper;

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
public class MenuCategoriesMapperTest {

    @Setter(onMethod_ = @Autowired)
    private MenuCategoriesMapper menuCatMapper;

    @Test
    @Disabled
    public void selectMenuCategories() {
        MenuCategoriesVO menuCatsVO = new MenuCategoriesVO();

        List<MenuCategoriesVO> menuCatLists = menuCatMapper.selectMenuCategories(menuCatsVO);

        log.info("메뉴 카테고리 리스트 이거다! - " + menuCatLists);
        assertNotNull(menuCatLists);
    }

}
