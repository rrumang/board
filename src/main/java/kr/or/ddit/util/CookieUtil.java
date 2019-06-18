package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	public static String cookieString; // 분석할 쿠키 문자열
	/**
	 * 
	* Method : setCookieString
	* 작성자 : PC08
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠키 문자열을 받는다.
	 */
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString; 
	}
	/**
	 * 
	* Method : getCookie
	* 작성자 : PC08
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다
	 */
	public static String getCookie(String cookie) {
		String[] cookieArray = cookieString.split(";");
		//cookieArray[0] = "userId=brown"
		//cookieArray[1] = "rememberMe=true"
		//cookieArray[2] = "test=testValue"
		String cookieValue = "";
		for (String str : cookieArray) {
			logger.debug("str : {}",str);
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				//cookieStr[0] = "userId"
				//cookieStr[1] = "true"
				cookieValue = cookieStr[1];
				break;
			}
		}
		return cookieValue;
	}
//	public static String getCookie(String cookie) {
//		//"rememberMe=true; userId=brown; test=test";
//		//cookie="userId"
//		String cookie2= "";
//		String[] cookies = cookieString.split(";");
//		for(int i=0; i<cookies.length; i++){
//			if(cookies[i].substring(0,cookies[i].indexOf("=")).trim().equals(cookie)){
//				cookie2 = cookies[i].substring(cookies[i].indexOf("=")+1);
//			}
//		}
//		return cookie2;
//	}

}
