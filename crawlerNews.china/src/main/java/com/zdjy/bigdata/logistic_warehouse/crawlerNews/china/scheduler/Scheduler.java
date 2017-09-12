package com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.crawler.Crawler;
import com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.entity.News;

@Component
public class Scheduler {
	@Autowired
	private Crawler crawler;
	
	@Scheduled(cron="0/30 * * * * ?")
	public void schedule(){
		//爬去互联网上的数据
		List<News> crawle = crawler.crawle();
		if(crawle==null||crawle.size()==0)
			return;
		for(News news:crawle){
			//发送rabbitMQ
//			System.out.println(news);
		}
		System.out.println(crawle.size());
	}
}
