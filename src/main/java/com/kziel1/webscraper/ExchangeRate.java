package com.kziel1.webscraper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeRate {
    private String purchase;
    private String sale;
}
