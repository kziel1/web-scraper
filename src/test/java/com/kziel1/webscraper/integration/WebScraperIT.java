package com.kziel1.webscraper.integration;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kziel1.webscraper.ScraperController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebScraperIT {
	@Autowired
	ScraperController scraperController;

	@Test
	public void test() {
		scraperController.getUsd();
		System.out.println("integrationtest");
	}
}