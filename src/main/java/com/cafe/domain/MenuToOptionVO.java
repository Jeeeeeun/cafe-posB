package com.cafe.domain;

import lombok.Data;

import java.util.List;

@Data
public class MenuToOptionVO {
    private MenusVO menu;
    private List<OptionsVO> options;
}
