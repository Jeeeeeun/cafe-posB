package com.cafe.service;

import com.cafe.domain.MenuToOptionVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Log4j2
public class MenuToOptionServiceTest {

    @Setter(onMethod_ = @Autowired)
    private MenuToOptionService menuToOptionService;

    @Test
    public void testGetAllMenesWithOptions() {
        List<MenuToOptionVO> allMenusWithOptions = menuToOptionService.getAllMenuWithOptions();

        log.info("메뉴랑 옵션들 서비스까지 잘 가져왔지? - " + allMenusWithOptions);

        assertNotNull(allMenusWithOptions);
    }

}
