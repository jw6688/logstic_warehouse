package com.zdjy.bigdata.logistic_warehouse.crawlerNews.people.crawler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.zdjy.bigdata.logistic_warehouse.crawlerNews.people.entity.News;
import com.zdjy.bigdata.logistic_warehouse.crawlerNews.people.util.DateUtils;
@Component
public class Crawler {
	private Set<String> set=new HashSet<>();
	private int num=0;
	public int getNum() {
		return num;
	}
	public List<News> crawle(){
		try {
			List<News> newses=new ArrayList<>();
			
			
			Document document = Jsoup.connect("http://news.ifeng.com/listpage/4550/0/1/rtlist.shtml").get();
			Elements select = document.select(".newsList ul li");
			for(int i=0;i<select.size();i++){
				News news = new News();
				news.setiDate(new Date());
				news.setWebSite("news.ifeng.com");
				news.setWebSiteName("凤凰网");
				Elements eq = select.eq(i);
				news.setpDate(DateUtils.getDate(eq.select("h4").text()));
				news.setUrl(eq.select("a").attr("href"));
				news.setTitle(eq.select("a").text());
				if (set.contains(news.getUrl())) {
					break;
				}
				set.add(news.getUrl());
				num++;
				crawlerSecond(news.getUrl(),news);
				newses.add(news);
			}
			return newses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void crawlerSecond(String url,News news) throws Exception{
		try {
			Document document = Jsoup.connect(news.getUrl()).get();
			Elements select = document.select("meta[name='keywords']");
			Elements select2 = document.select("meta[name='description']");
			news.setKeywords(select.attr("content").replaceAll(" ",","));
			news.setDescription(select2.attr("content").replaceAll("[　\\s]+",""));
			Elements select3 = document.select("#main_content");
			news.setContent(select3.html());
			Elements select4 = select3.select("img");
			if(select4.size()>0){
				news.setImgUrl(select4.eq(0).outerHtml());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
