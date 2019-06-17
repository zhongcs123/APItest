package HttpClient.HttpClientSpringboot.utils;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

public class reponseUtil {
	
	
	/**
	 * 响应内容转换为String字符串
	 * @param response 响应内容CloseableHttpResponse类型
	 * @return 响应内容，String类型
	 * @throws ParseException
	 * @throws IOException
	 */
	public String contentString(CloseableHttpResponse response) throws ParseException, IOException {
		String conteString=EntityUtils.toString(response.getEntity(), "utf-8");
		return conteString;
	}
	
	/**
	 * 响应状态码
	 * @param response 响应内容CloseableHttpResponse类型
	 * @return 响应状态码，int类型，例正常：200
	 * @throws ParseException
	 * @throws IOException
	 */
	public int contentStatus(CloseableHttpResponse response) throws ParseException, IOException {
		int statusCode=response.getStatusLine().getStatusCode();
		return statusCode;
	}
}
