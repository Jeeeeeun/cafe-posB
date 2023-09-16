package com.cafe.mapper;

import com.cafe.domain.MenuToOptionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuToOptionMapper {
    List<MenuToOptionVO> selectAllMenuWithOptions();
}
