package com.cafe.service.impl;

import com.cafe.domain.MenusVO;
import com.cafe.mapper.MenusMapper;
import com.cafe.service.MenusService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenusServiceImpl implements MenusService {

    @NonNull
    private MenusMapper menusMapper;

    @Transactional
    public int registerMenuIfValid(MenusVO menusVO) {

        String menuName = menusVO.getMenu_name();
        int menuCategoryId = menusVO.getMenu_category_id();
        int menuPage = menusVO.getMenu_page();
        int menuRow = menusVO.getMenu_row();
        int menuColumn = menusVO.getMenu_column();

        // 유효한 위치인지 검사
        boolean invalidPosition = isMenuAtPosition(menuCategoryId, menuPage, menuRow, menuColumn);

        // 유효한 이름인지 검사
        boolean invalidName = isSameMenuName(menuName);

        // 등록할 메뉴 개수 초기화
        int addMenu = 0;

        if (!invalidPosition && !invalidName) {
            addMenu = registerMenu(menusVO);
        }
        
        return addMenu;
    }
    @Override
    public boolean isMenuAtPosition(int menuCategoryId, int menuPage, int menuRow, int menuColumn) { // 해당 위치에 메뉴 블록 있는지 조사
        int count = menusMapper.countMenusAtPosition(menuCategoryId, menuPage, menuRow, menuColumn);

        // 해당 위치에 이미 메뉴 블록이 있으면 true
        return count >= 1;
    }

    @Override
    public boolean isSameMenuName(String menuName) { // 이미 같은 이름의 메뉴가 있는지 조사
        int count = menusMapper.countSameMenuName(menuName);

        // 해당 이름과 같은 메뉴가 있으면 true
        return count >= 1;
    }

    @Override
    public int registerMenu(MenusVO menusVO) { // 메뉴 생성(insert)
        return menusMapper.insertMenu(menusVO);
    }

    @Override
    public List<MenusVO> getMenus() { // 메뉴 전체 가져오기(select)
        try {
            return menusMapper.selectAllMenus();
        } catch (DataAccessException e) {
            throw new DataAccessResourceFailureException("메뉴 목록을 불러오던 중 오류가 발생했습니다.", e);
        } catch (Exception e) {
            throw new RuntimeException("예상치 못한 오류가 발생했습니다.", e);
        }
    }
}
