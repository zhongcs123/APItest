package HttpClient.HttpClientSpringboot.testCase;

import org.testng.annotations.Test;

import HttpClient.HttpClientSpringboot.utils.cookieUtil;
import HttpClient.HttpClientSpringboot.utils.httpClientRequest;
import HttpClient.HttpClientSpringboot.utils.reponseUtil;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.testng.annotations.AfterClass;

public class cookieTest {
	cookieUtil cookieStores;
	httpClientRequest Request;
	reponseUtil reponse;
	CookieStore store;

	@Test
	public void testCookie() throws ClientProtocolException, IOException {

		BasicClientCookie cookie1 = cookieStores.cookie("cookieName1", "cookieValue1", "localhost");
		BasicClientCookie cookie2 = cookieStores.cookie("cookieName2", "cookieValue2", "localhost");
		store.addCookie(cookie1);
		store.addCookie(cookie2);

		CloseableHttpResponse content = Request.get("http://localhost:1111/getDemo/cookies", store);
		String contentString = reponse.content(content);
		System.out.println(contentString);

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("test");
		cookieStores = new cookieUtil();
		Request = new httpClientRequest();
		reponse = new reponseUtil();
		store = new BasicCookieStore();

	}

	@AfterClass
	public void afterClass() {

	}

}
