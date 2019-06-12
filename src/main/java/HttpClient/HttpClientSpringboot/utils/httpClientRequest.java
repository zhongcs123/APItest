package HttpClient.HttpClientSpringboot.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class httpClientRequest {
	
	/**
	 * get 请求方法
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的HttpClient对象
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpGet的请求对象
		HttpGet getRequest=new HttpGet(url);
		
		 //执行请求,相当于点击发送按钮，然后赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(getRequest);
		return HttpResponse;
	}
	
	
	/**
	 * get 请求方法（带请求头信息）
	 * @param url
	 * @param headerMap  请求头信息
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的HttpClient对象
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpGet的请求对象
		HttpGet request=new HttpGet(url);
		
		//加载请求头到httpget对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			request.setHeader(entry.getKey(), entry.getValue());
		}
		
		 //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
		CloseableHttpResponse httpResponse=client.execute(request);

		return httpResponse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}