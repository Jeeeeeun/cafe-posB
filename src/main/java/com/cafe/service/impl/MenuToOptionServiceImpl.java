package com.cafe.service.impl;

import com.cafe.domain.MenuToOptionVO;
import com.cafe.mapper.MenuToOptionMapper;
import com.cafe.service.MenuToOptionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuToOptionServiceImpl implements MenuToOptionService {

    @NonNull
    private MenuToOptionMapper menuToOptionMapper;

    @Override
    public List<MenuToOptionVO> getAllMenuWithOptions() {
        try {
            return menuToOptionMapper.selectAllMenuWithOptions();
        } catch (DataAccessException e) {
            throw new DataAccessResourceFailureException("메뉴와 옵션들을 불러오던 중 오류가 발생했습니다. - ", e);
        } catch (Exception e) {
            throw new RuntimeException("예상치 못한 오류가 발생했습니다. - ", e);
        }
    }
}
