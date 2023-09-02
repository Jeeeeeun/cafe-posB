package com.cafe.mapper;

import com.cafe.domain.MenusVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenusMapper {

    // 해당 위치에 메뉴 블록 있는지 조사
    int countMenusAtPosition(int menuCategoryId, int menuPage, int menuRow, int menuColumn);

    // 이미 같은 이름의 메뉴가 있는지 조사
    int countSameMenuName(String menuName);

    // 메뉴 생성(insert)
    int insertMenu(MenusVO menuVO);

    // 메뉴 전체 가져오기(select)
    List<MenusVO> selectAllMenus();
}
