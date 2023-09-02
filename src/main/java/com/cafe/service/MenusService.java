package com.cafe.service;

import com.cafe.domain.MenusVO;

import java.util.List;

public interface MenusService {

    // 해당 위치에 메뉴 블록 있는지 조사
    boolean isMenuAtPosition(int menuCategoryId, int menuPage, int menuRow, int menuColumn);

    // 이미 같은 이름의 메뉴가 있는지 조사
    boolean isSameMenuName(String menuName);
    
    // 메뉴 생성(insert)
    int registerMenu(MenusVO menusVO);

    // 메뉴 전체 가져오기(select)
    List<MenusVO> getMenus() throws Exception;
}
