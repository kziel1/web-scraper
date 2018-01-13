package com.kziel1.webscraper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContiExchangeRate {
    private String currency;
    private ExchangeRate under4k;
    private ExchangeRate over4k;
    private ExchangeRate cashless;
}
