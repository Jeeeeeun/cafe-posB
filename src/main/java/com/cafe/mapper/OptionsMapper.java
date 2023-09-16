package com.cafe.mapper;

import com.cafe.domain.OptionsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionsMapper {
	List<OptionsVO> selectAllOptions();
}
