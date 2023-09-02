package com.cafe.service.impl;

import com.cafe.domain.MenuCategoriesVO;
import com.cafe.mapper.MenuCategoriesMapper;
import com.cafe.service.MenuCategoriesService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuCategoriesServiceImpl implements MenuCategoriesService {

    @Setter(onMethod_ = @Autowired)
    private MenuCategoriesMapper menuCategoriesMapper;

    @Override
    public List<MenuCategoriesVO> getMenuCategories(MenuCategoriesVO menuCategoriesVO) {
        return menuCategoriesMapper.selectMenuCategories(menuCategoriesVO);
    }
}
