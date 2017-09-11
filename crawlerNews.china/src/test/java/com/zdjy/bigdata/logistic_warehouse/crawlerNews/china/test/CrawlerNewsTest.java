package com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.test;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.Gson;
import com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.entity.ChinaNews;
import com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.entity.ChinaResponse;

public class CrawlerNewsTest {
	@Test
	public void test001() throws Exception{
		HttpClientBuilder builder = HttpClientBuilder.create();
		CloseableHttpClient client = builder.build();
		
		
		HttpGet get=new HttpGet("http://rollnews.china.com/interface/rollnews.php?method=getNews&channelid=41&page=1&limit=60&_=1505110710161");
		
		CloseableHttpResponse response = client.execute(get);
		
		HttpEntity entity = response.getEntity();
		
		String string = EntityUtils.toString(entity, "utf-8");
		
		ChinaResponse chinaResponse = new Gson().fromJson(string, ChinaResponse.class);
		List<ChinaNews> info = chinaResponse.getInfo();
		for(ChinaNews chinaNews:info){
			System.out.println(chinaNews.toString());
		}
	}
}
