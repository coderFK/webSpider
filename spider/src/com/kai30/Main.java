package com.kai30;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String [] args) throws ClientProtocolException, IOException{
//		useHttpClient();
//		useJsoup();
		useboth();
	}

	private static void useboth() throws ParseException, IOException {
		// TODO Auto-generated method stub
		HttpClient hClient = new DefaultHttpClient();
		HttpGet hGet = new HttpGet("http://www.huawei.com");
		HttpResponse response = hClient.execute(hGet);
		String content = EntityUtils.toString(response.getEntity());
		Document doc = Jsoup.parse(content);
		Elements ele = doc.getElementsByTag("a");
		for (Element element : ele) {
			System.out.println(element.attr("href"));
		}
	}

	private static void useJsoup() throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("http://123.206.213.249").get();
//		Elements ele = doc.getElementsByTag("a");
		Elements ele = doc.select("div.class_other a");
		for (Element element : ele) {
			System.out.println(element.attr("href"));
		}
	}

	private static void useHttpClient()throws ClientProtocolException, IOException{
		// TODO Auto-generated method stub
		HttpClient hClient = new DefaultHttpClient();
		//设置响应时间参数， 代理服务器
//		hClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000)
//		.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000)
//		.setParameter(ConnRouteParams.DEFAULT_PROXY, new HttpHost("123.206.213.249", 80));
		HttpGet hGet = new HttpGet("http://www.huawei.com/");
		HttpResponse response = hClient.execute(hGet);
		String content = EntityUtils.toString(response.getEntity(), "gb2312");
		System.out.println(content);
	}
}
