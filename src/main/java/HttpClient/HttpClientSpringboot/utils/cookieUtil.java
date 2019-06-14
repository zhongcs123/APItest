package HttpClient.HttpClientSpringboot.utils;

import org.apache.http.impl.cookie.BasicClientCookie;

public class cookieUtil {
	/**
	 * 设置cookie，未添加到cookieStore中，需再执行下面代码添加
	 * CookieStore cookieStore = new BasicCookieStore();
	 * cookieStore.addCookie(cookie);
	 * @param name cookie的name字段的值
	 * @param value cookie的value字段的值
	 * @param domain 域名
	 * @return
	 */
	public BasicClientCookie cookie(String name, String value, String domain) {
		BasicClientCookie cookie = new BasicClientCookie(name, value);// 添加cookie的name、value
		cookie.setDomain(domain);// 添加域名
		return cookie;
	}

}
