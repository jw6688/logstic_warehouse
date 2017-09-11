package com.zdjy.bigdata.logistic_warehouse.crawlerNews.ifeng.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class CrawlerNewsTest {
	@Test
	public void test001() throws Exception{
		Document document = Jsoup.connect("http://news.ifeng.com/listpage/4550/0/1/rtlist.shtml").get();
		Elements select = document.select(".newsList ul li");
		for(int i=0;i<select.size();i++){
			Elements eq = select.eq(i);
			String time = eq.select("h4").text();
			System.out.println(time);
			Elements select2 = eq.select("a");
			String url = select2.attr("href");
			System.out.println(url);
			String titile = select2.text();
			System.out.println(titile);
		}
	}
}
