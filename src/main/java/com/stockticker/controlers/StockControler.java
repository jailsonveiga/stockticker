package com.stockticker.controlers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api/stocks")
@RestController
public class StockControler {
    private String stockEndpoint = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=";
    private String apiKey = "3WTPF054W93CLAB9";
// https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=demo
    @GetMapping("overview")
    public Object stockTicker(@RequestParam String symbol, RestTemplate restTemplate) {
        stockEndpoint += symbol;
        stockEndpoint += "&apikey=";
        stockEndpoint += apiKey;

        return restTemplate.getForObject(stockEndpoint, Object.class);
    }
}
