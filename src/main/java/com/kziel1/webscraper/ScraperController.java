package com.kziel1.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class ScraperController {

    @RequestMapping("/")
    @ResponseBody
    String getUsd() {

        Document doc = null;
        Node node = null;
        try {
            doc = Jsoup.connect("http://www.kantorconti.pl/pl/").get();
            node = doc.select("tbody tr:nth-child(2)").get(0).childNode(9);
//            extractContiExchangeRates(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return node == null ? "error" : node.toString();
        return node == null ? "error" : extractContiExchangeRates(doc).toString();
    }

    private List<ContiExchangeRate> extractContiExchangeRates(Document doc) {
        Element tbody = doc.select("tbody").get(1);
        List<ContiExchangeRate> contiExchangeRates = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ContiExchangeRate contiExchangeRate = new ContiExchangeRate();
            contiExchangeRate.setCurrency(tbody.childNode(2 * i + 1).childNode(3).toString().replaceAll("\\<[^>]*>", ""));
            contiExchangeRate.setUnder4k(new ExchangeRate(tbody.childNode(2 * i + 1).childNode(5).toString().replaceAll("\\<[^>]*>", ""), tbody.childNode(2 * i + 1).childNode(7).toString().replaceAll("\\<[^>]*>", "")));
            contiExchangeRate.setOver4k(new ExchangeRate(tbody.childNode(2 * i + 1).childNode(9).toString().replaceAll("\\<[^>]*>", ""), tbody.childNode(2 * i + 1).childNode(11).toString().replaceAll("\\<[^>]*>", "")));
            contiExchangeRate.setCashless(new ExchangeRate(tbody.childNode(2 * i + 1).childNode(13).toString().replaceAll("\\<[^>]*>", ""), tbody.childNode(2 * i + 1).childNode(15).toString().replaceAll("\\<[^>]*>", "")));
            contiExchangeRates.add(contiExchangeRate);
        }
        return contiExchangeRates;
    }
}
