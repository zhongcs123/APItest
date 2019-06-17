package HttpClient.HttpClientSpringboot.utils;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

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
	
	
	/**
	 * 响应头信息数据对比判断
	 * @param response 响应内容CloseableHttpResponse类型
	 * @param headers 预期结果（填入格式：name:value。例：Content-Type:text/plain; charset=utf-8）
	 */
	public void contentHeader(CloseableHttpResponse response,String headers) {
		Header[] headerArry=response.getAllHeaders();
		for (int i = 0; i < headerArry.length; i++) {
			String h=headerArry[i].getName()+":"+headerArry[i].getValue();
			if (h.equalsIgnoreCase(headers)) {
//				System.out.println("响应信息头header数据正确。");
				break;
			}else if (i<headerArry.length) {
				if (i==headerArry.length-1) {
					try {
						throw new Exception("返回头信息数据错误：(预期结果：“"+headers+"”;实际结果：“"+h+"”)");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				continue;
			}
		}	
	}
}
