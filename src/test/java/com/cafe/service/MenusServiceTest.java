package com.cafe.service;

import com.cafe.domain.MenusVO;
import com.cafe.mapper.MenusMapper;
import com.cafe.service.impl.MenusServiceImpl;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Log4j2
public class MenusServiceTest {

    @Setter(onMethod_ = @Autowired)
    private MenusService menusService;

    @Mock
    private MenusMapper menusMapper;

    @InjectMocks
    private MenusServiceImpl menusServiceImpl;

    @Test
    @Disabled
    public void isMenuAtPositionTest() { // 해당 위치에 이미 메뉴 블록 있나 조사
        int menuCategoryId = 2;
        int menuPage = 1;
        int menuRow = 1;
        int menuColumn = 1;

        boolean alreadyExist = menusService.isMenuAtPosition(menuCategoryId, menuPage, menuRow, menuColumn);

        log.info("해당 위치에 이미 메뉴 블록이 있어? - " + alreadyExist);

        assertTrue(alreadyExist);
    }

    @Test
    @Disabled
    public void isSameMenuNameTest() { // 메뉴 이름 이미 존재하는지 중복 검사
        String menuName = "아메리카노";

        boolean alreadyExist = menusService.isSameMenuName(menuName);

        log.info(menuName + " ← 이 이름이 존재해? - " + alreadyExist);

        assertTrue(alreadyExist);
    }

    @Test
    @Disabled
    public void registerMenuTest() { // 진짜 메뉴 등록
        MenusVO menusVO = new MenusVO();

        menusVO.setMenu_category_id(3);
        menusVO.setMenu_name("딸기스무디");
        menusVO.setMenu_price(6000);
        menusVO.setMenu_isFavorite('F');
        menusVO.setMenu_colorScheme("rose");
        menusVO.setMenu_page(1);
        menusVO.setMenu_row(1);
        menusVO.setMenu_column(1);

        int addRow = menusService.registerMenu(menusVO);

        log.info(addRow + "건 등록 요청됐습니다.");

        assertEquals(1, addRow);
    }

    @Test
    @Disabled
    public void registerMenuIfValidTest() { // 메뉴 위치와 이름이 유효하다면 등록해줘
        MenusVO menusVO = new MenusVO();

        menusVO.setMenu_category_id(2);
        menusVO.setMenu_name("카페라떼");
        menusVO.setMenu_price(5000);
        menusVO.setMenu_isFavorite('F');
        menusVO.setMenu_colorScheme("white");
        menusVO.setMenu_page(1);
        menusVO.setMenu_row(1);
        menusVO.setMenu_column(2);


        int noDuplicated = 0;
        int affectedRow = 1;

        when(menusMapper.countMenusAtPosition(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(noDuplicated);
        when(menusMapper.countSameMenuName(anyString())).thenReturn(noDuplicated);
        when(menusMapper.insertMenu(any(MenusVO.class))).thenReturn(affectedRow);

        int addRow = menusServiceImpl.registerMenuIfValid(menusVO);

        assertEquals(affectedRow, addRow);
    }

    @Test
    @Disabled
    public void getMenusTest() throws Exception { // 메뉴 전체 가져오기
        List<MenusVO> menuLists = menusService.getMenus();

        assertNotNull(menuLists);
    }
}
