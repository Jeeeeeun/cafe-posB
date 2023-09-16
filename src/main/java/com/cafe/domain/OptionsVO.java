package com.cafe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OptionsVO {
    @JsonProperty("option_id")
    private int option_id;

    @JsonProperty("option_category_id")
    private int option_category_id;

    @JsonProperty("option_name")
    private String option_name;

    @JsonProperty("option_is_free")
    private char option_is_free;

    @JsonProperty("option_price")
    private int option_price;
}
