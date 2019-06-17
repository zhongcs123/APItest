package HttpClient.HttpClientSpringboot.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * get、post方法请求封装，返回响应内容CloseableHttpResponse类型内容；
 */
public class httpClientRequest {
	
	/**
	 * get 请求方法
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的HttpClient对象，相当于打开浏览器
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpGet的请求对象，相当于输入网址	
		HttpGet getRequest=new HttpGet(url);
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
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
		HttpGet getRequest=new HttpGet(url);
		
		//加载请求头到httpget对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			getRequest.setHeader(entry.getKey(), entry.getValue());
		}
		
		//发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse httpResponse=client.execute(getRequest);
		return httpResponse;
	}
	
	
	/**
	 * get 请求方法(带自定义cookies)
	 * @param url
	 * @param cookieStore
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse get(String url,CookieStore cookieStore) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client，自定义添加cookieStore
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpGet的请求对象
		HttpGet getRequest=new HttpGet(url);
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(getRequest);
		return HttpResponse;
	}
	
	/**
	 * get 请求方法（URL，带cookie，带header头信息）
	 * @param url
	 * @param cookieStore
	 * @param headerMap
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse get(String url,CookieStore cookieStore,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client，自定义添加cookieStore
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpGet的请求对象
		HttpGet getRequest=new HttpGet(url);
		
		//加载请求头到httpget对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			getRequest.setHeader(entry.getKey(), entry.getValue());
		}
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(getRequest);
		return HttpResponse;
	}
	
	
	/**
	 * post 请求方法
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的HttpClient对象
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(request);
		return HttpResponse;
	}
	
	
	/**
	 * post 请求方法（带请求头信息）
	 * @param url
	 * @param headerMap  请求头信息
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的HttpClient对象
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//加载请求头到HttpPost对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			request.setHeader(entry.getKey(), entry.getValue());
		}
		
		//发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse httpResponse=client.execute(request);
		return httpResponse;
	}
	
	
	/**
	 * post 请求方法(带自定义cookies)
	 * @param url
	 * @param cookieStore
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,CookieStore cookieStore) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client，自定义添加cookieStore
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(request);
		return HttpResponse;
	}
	
	/**
	 * post 请求方法（URL，带cookie，带header头信息）
	 * @param url
	 * @param cookieStore
	 * @param headerMap
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,CookieStore cookieStore,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client，自定义添加cookieStore
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//加载请求头到HttpPost对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			request.setHeader(entry.getKey(), entry.getValue());
		}
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(request);
		return HttpResponse;
	}
	
	/**
	 * post 请求方法（带参数body）
	 * @param url
	 * @param params 参数(格式:key1=value1&key2=value2) 
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,String params) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//配置body，添加参数
		request.setEntity(new StringEntity(params,"UTF-8"));
		
		//发送请求，响应内容赋值response对象
		CloseableHttpResponse response=client.execute(request);
		
		client.close();
		
		return response;
	}
	
	/**
	 * post 请求方法（带参数body,带header信息头）
	 * @param url
	 * @param params 参数(格式:key1=value1&key2=value2) 
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,String params,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//配置body，添加参数
		request.setEntity(new StringEntity(params,"UTF-8"));
		
		//加载请求头到HttpPost对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			request.setHeader(entry.getKey(), entry.getValue());
		}
		
		//发送请求，响应内容赋值response对象
		CloseableHttpResponse response=client.execute(request);
		return response;
	}
	
	/**
	 * post 请求方法(带参数body，带cookies)
	 * @param url
	 * @param params 参数(格式:key1=value1&key2=value2) 
	 * @param cookieStore
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,String params,CookieStore cookieStore) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client，自定义添加cookieStore
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//配置body，添加参数
		request.setEntity(new StringEntity(params,"UTF-8"));
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(request);
		return HttpResponse;
	}
	
	/**
	 * post 请求方法（URL，带cookie，带header头信息）
	 * @param url
	 * @param params 参数(格式:key1=value1&key2=value2) 
	 * @param cookieStore
	 * @param headerMap
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,String params,CookieStore cookieStore,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client，自定义添加cookieStore
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//配置body，添加参数
		request.setEntity(new StringEntity(params,"UTF-8"));
		
		//加载请求头到HttpPost对象
		for (Entry<String, String> entry:headerMap.entrySet()) {
			request.setHeader(entry.getKey(), entry.getValue());
		}
		
		 //发送请求，然后响应内容赋值给HttpResponse对象接收
		CloseableHttpResponse HttpResponse=client.execute(request);
		return HttpResponse;
	}
	
}
