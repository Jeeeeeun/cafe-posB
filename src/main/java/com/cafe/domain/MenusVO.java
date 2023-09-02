package com.cafe.domain;

import lombok.Data;

@Data
public class MenusVO {
    private int menu_id;
    private int menu_category_id;
    private String menu_name;
    private int menu_price;
    private char menu_isFavorite;
    private String menu_colorScheme;
    private int menu_page;
    private int menu_row;
    private int menu_column;
}
