package HttpClient.HttpClientSpringboot.utils;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 读取配置文件
 */
public class ResourceBundleUtil {
	/**
	 * 读取配置文件，转换中文utf-8格式
	 * @param file 要读取的文件名称，填文件名
	 * @param key 获取key的值，填key名称
	 * @return
	 */
	public String read(String file,String key) {
		ResourceBundle bundle=ResourceBundle.getBundle(file,Locale.CHINA);
		String content="";
		try {
			content=new String(bundle.getString(key).getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return content;
	}

}
