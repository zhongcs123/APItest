package HttpClient.HttpClientSpringboot.utils;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

public class reponseUtil {
	
	
	public String content(CloseableHttpResponse response) throws ParseException, IOException {
		String conteString=EntityUtils.toString(response.getEntity(), "utf-8");
		return conteString;
	}
}
