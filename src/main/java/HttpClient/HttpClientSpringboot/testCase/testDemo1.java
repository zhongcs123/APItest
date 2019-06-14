package HttpClient.HttpClientSpringboot.testCase;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import HttpClient.HttpClientSpringboot.utils.httpClientRequest;

public class testDemo1 {
	static httpClientRequest reponse;
	public void reponse() throws ClientProtocolException, IOException {
		CloseableHttpResponse r=reponse.get("https://www.baidu.com");
		String responseString=EntityUtils.toString(r.getEntity(),"utf-8");
		System.out.println(responseString);
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		testDemo1 test=new testDemo1();
		reponse=new httpClientRequest();
		test.reponse();
	}
	

}
