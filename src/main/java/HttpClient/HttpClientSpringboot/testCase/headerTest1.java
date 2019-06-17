package HttpClient.HttpClientSpringboot.testCase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.util.EntityUtils;

import HttpClient.HttpClientSpringboot.utils.reponseUtil;

public class headerTest1 {
	static reponseUtil reponseContent;
	CloseableHttpResponse response;
	
	public HashMap<String, String> headerUtil() {
		
		//准备信息头header
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("content-type", "application/json");
		return map;
	}
	
	public void headerDemo() throws ClientProtocolException, IOException {
		
		
		//创建一个可关闭的httpclient
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个get的请求
		HttpGet get=new HttpGet("http://localhost:1111/getDemo/header");
		
		//get的请求添加header头信息
		for(Entry<String, String> entry:headerUtil().entrySet()) {
			get.addHeader(entry.getKey(), entry.getValue());
		}
		
		//发送请求，响应内容赋值给response对象
		response=client.execute(get);
		
		
		
		//响应内容转换String字符串
		String content=EntityUtils.toString(response.getEntity(),"utf-8");
		
//		System.out.println(content);
		System.out.println(response);
		
		Header[] headerArry=response.getAllHeaders();
		for(Header header:headerArry) {
			System.out.println(header.getName()+":"+header.getValue());
		}	
		
	}
	
	public void reponseTest() {
		reponseContent.contentHeader(response, "Content-Type:text/plain; charset=utf-8");
	}
	

	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		headerTest1 t=new headerTest1();
		reponseContent=new reponseUtil();
		
		t.headerDemo();
		t.reponseTest();

	}

}
