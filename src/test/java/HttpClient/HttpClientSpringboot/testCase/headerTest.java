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

public class headerTest {
	httpClientRequest request;
	reponseUtil reponse;
	ResourceBundleUtil bundle;
	CloseableHttpResponse responseContent;
  @Test
  public void headersDemo() throws ClientProtocolException, IOException {
	  
  }
  @BeforeClass
  public void beforeClass() {
	  bundle=new ResourceBundleUtil();//读取配置文件
	  request=new httpClientRequest();//发送请求
	  reponse=new reponseUtil();//获取响应内容
	  
  }

  @AfterClass
  public void afterClass() throws IOException {
	  responseContent.close();
  }

}
