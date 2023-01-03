package com.sanvalero.telovendo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyListDTO {

    private String name;
    private float total;

    private long buylst;
}
