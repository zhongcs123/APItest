package HttpClient.HttpClientSpringboot.testCase;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class cookieStore {
	public void cookieStoreDemo() throws ClientProtocolException, IOException {
		//这一段是只添加一个cookie
		CookieStore cookieStore=new BasicCookieStore();
		BasicClientCookie cookie=new BasicClientCookie("cookieName", "cookieValue");//
		cookie.setDomain("localhost");//添加域名
//		cookie.setPath("/");//添加path
		cookieStore.addCookie(cookie);//把cookie添加到cookieStore中
		
		
		//创建一个可关闭的HttpClient，自定义添加cookieStore
		CloseableHttpClient httpClient=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpGet的请求对象，填入URL
		HttpGet httpGet=new HttpGet("http://localhost:1111/getDemo/cookies");
		
		//发送请求，响应内容赋值response对象
		CloseableHttpResponse response=httpClient.execute(httpGet);
		
		//响应内容转换String字符串，赋值content对象
		String content=EntityUtils.toString(response.getEntity(), "utf-8");
		
		System.out.println(content);
		
		
	}
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		cookieStore test=new cookieStore();
		test.cookieStoreDemo();
	}
	
	

}
