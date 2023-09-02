package com.cafe.mapper;

import com.cafe.domain.MenuCategoriesVO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface MenuCategoriesMapper {
    List<MenuCategoriesVO> selectMenuCategories(MenuCategoriesVO vo);
}
