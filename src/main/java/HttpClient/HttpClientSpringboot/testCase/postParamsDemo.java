package HttpClient.HttpClientSpringboot.testCase;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class postParamsDemo {

	/**
	 * post 请求方法（带参数body）
	 * @param url
	 * @param entityString
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse post(String url,String entityString) throws ClientProtocolException, IOException {
		
		//创建一个可关闭的client
		CloseableHttpClient client=HttpClients.createDefault();
		
		//创建一个HttpPost的请求对象
		HttpPost request=new HttpPost(url);
		
		//配置body，添加参数
		request.setEntity(new StringEntity(entityString));
		
		//发送请求，响应内容赋值response对象
		CloseableHttpResponse response=client.execute(request);
		return response;
	}
	
	public  void postParams() throws ClientProtocolException, IOException {
		 String paramsString="name=test&age=18";  
		CloseableHttpResponse content =post("http://localhost:1111/postwithparam",paramsString);
		System.out.println(EntityUtils.toString(content.getEntity(), "utf-8"));
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		postParamsDemo p=new postParamsDemo();
		p.postParams();
	}
}
