package com.cafe.service;
import com.cafe.domain.MenuCategoriesVO;

import java.util.List;

public interface MenuCategoriesService {
    List<MenuCategoriesVO> getMenuCategories(MenuCategoriesVO menuCategoriesVO);
}
