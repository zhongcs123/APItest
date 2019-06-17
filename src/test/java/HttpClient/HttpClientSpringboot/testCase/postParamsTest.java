package HttpClient.HttpClientSpringboot.testCase;

import org.testng.annotations.Test;

import HttpClient.HttpClientSpringboot.utils.ResourceBundleUtil;
import HttpClient.HttpClientSpringboot.utils.httpClientRequest;
import HttpClient.HttpClientSpringboot.utils.reponseUtil;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.AfterClass;

public class postParamsTest {
	httpClientRequest request;
	reponseUtil reponse;
	ResourceBundleUtil bundle;
	CloseableHttpResponse responseContent;
  @Test
  public void postParamsDemo1() throws ClientProtocolException, IOException {
	  responseContent=request.post(bundle.read("urlUtil", "post_url"), bundle.read("urlUtil", "post_json"));//发送请求
	  String content=reponse.contentString(responseContent);
	  System.out.println(content);
	  System.out.println("响应状态码："+reponse.contentStatus(responseContent));
	  
  }
  @BeforeClass
  public void beforeClass() {
	  request=new httpClientRequest();
	  reponse=new reponseUtil();
	  bundle=new ResourceBundleUtil();
	  
	  
  }

  @AfterClass
  public void afterClass() throws IOException {
	  responseContent.close();//关闭资源
  }

}
