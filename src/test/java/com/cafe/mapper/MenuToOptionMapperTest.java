package com.cafe.mapper;

import com.cafe.domain.MenuToOptionVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Log4j2
public class MenuToOptionMapperTest {

    @Setter(onMethod_ = @Autowired)
    private MenuToOptionMapper menuToOptionMapper;

    @Test
    //@Disabled
    public void testSelectAllMenuWithOptions() {
        List<MenuToOptionVO> allMenusOptions = menuToOptionMapper.selectAllMenuWithOptions();

        log.info("모든 메뉴와 옵션들 여깄다 - " + allMenusOptions);
        log.info("모든 메뉴와 옵션들 여깄다 - " + allMenusOptions.get(8).getOptions());

        assertNotNull(allMenusOptions);
    }
}
