package com.kai30;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

public class AC_QQ {
	public static void main(String [] args) throws ClientProtocolException, IOException{
//		useHttpClient();
//		useJsoup();
		useboth();
//		getTitle();
	}
 
	private static void getTitle() throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("http://ac.qq.com/ComicView/index/id/505432/cid/441").get();
		Elements ele = doc.select("head title");
		System.out.println(ele.text());
//		Elements ele_imgUri = doc.getElementsByAttributeValue("rel", "Shortcut Icon");
//		System.out.println(ele_imgUri.attr("href"));
		
	}

	private static void useboth() throws ParseException, IOException {
		// TODO Auto-generated method stub
		HttpClient hClient = new DefaultHttpClient();
		HttpGet hGet = new HttpGet("http://ac.qq.com/VIP");
		HttpResponse response = hClient.execute(hGet);
		String content = EntityUtils.toString(response.getEntity());
//		System.out.println(content);
		
//		File file = new File("D:\\hy_log.txt");
//		ByteArrayInputStream bai = new ByteArrayInputStream(content.getBytes());
//		OutputStream os = new FileOutputStream(file);
//		int bytesRead = 0;
//		byte[] buffer = new byte[8192];
//		while ((bytesRead = bai.read(buffer, 0, 8192)) != -1) {
//			os.write(buffer, 0, bytesRead);
//		}
//		os.close();
//		bai.close();
		
		Document doc = Jsoup.parse(content);
		Elements ele = doc.getElementsByClass("in-works-name");
		
		for (Element element : ele) {
			System.out.println(element.text());
		}
		
//		Elements ele = doc.select("head script");
//		System.out.println(ele.text());
//		Elements ele = doc.getElementsByTag("a");
//		for (Element element : ele) {
//			System.out.println(element.attr("href"));
//		}
	}

	private static void useJsoup() throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("file://G:\\github\\bookmarks\\bookmarks_16_11_22.html").get();
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
