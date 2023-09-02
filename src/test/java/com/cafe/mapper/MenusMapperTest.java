package com.cafe.mapper;

import com.cafe.domain.MenusVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Log4j2
public class MenusMapperTest {
    @Setter(onMethod_ = @Autowired)
    private MenusMapper menusMapper;

    @Test
    @Disabled
    public void countMenusAtPositionTest() { // 해당 위치에 메뉴 블록 있는지 조사

        int menuCategoryId = 2;
        int menuPage = 1;
        int menuRow = 1;
        int menuColumn = 1;

        int count = menusMapper.countMenusAtPosition(menuCategoryId, menuPage, menuRow, menuColumn);

        log.info("그 위치에 메뉴 블록이 " + count + "개 있습니다.");

        assertEquals(0, count);
    }

    @Test
    @Disabled
    public void countSameMenuName() { // 이미 같은 이름의 메뉴가 있는지 조사
        String menuName = "아메리카노";

        int count = menusMapper.countSameMenuName(menuName);

        log.info("중복된 이름이 " + count + "개 있음");
        
        assertEquals(1, count);
    }

    @Test
    @Disabled
    public void insertMenu() { // 메뉴 생성(insert)

        MenusVO menusVO = new MenusVO();

        menusVO.setMenu_category_id(2);
        menusVO.setMenu_name("아메리카노");
        menusVO.setMenu_price(4000);
        menusVO.setMenu_isFavorite('F');
        menusVO.setMenu_colorScheme("white");
        menusVO.setMenu_page(1);
        menusVO.setMenu_row(1);
        menusVO.setMenu_column(1);

        int affectedRow = menusMapper.insertMenu(menusVO);

        log.info("메뉴 등록 요청 " + affectedRow + "건");

        assertEquals(1, affectedRow);
    }

    @Test
    @Disabled
    public void selectAllMenus() { // 메뉴 전체 가져오기(select)
        List<MenusVO> menuLists = menusMapper.selectAllMenus();

        log.info("메뉴 목록 전부 여깄어 - " + menuLists);

        assertNotNull(menuLists);
    }
}
