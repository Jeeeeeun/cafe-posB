package com.cafe.mapper;

import com.cafe.domain.OptionsVO;
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
public class OptionsMapperTest {
	@Setter(onMethod_ = @Autowired)
	private OptionsMapper optionsMapper;

	@Test
	@Disabled
	public void testSelectAllOptions() {
		List<OptionsVO> allOptionsList = optionsMapper.selectAllOptions();

		log.info("모든 옵션 목록들 여깄음 - " + allOptionsList);
		assertNotNull(allOptionsList);
	}
}
