package com.txc.kinect.mvc.utils;

/**
 * 提供验证字符串空或者非空方法
 */
public class StringUtils {

	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(cs.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(final CharSequence cs){
		return !isBlank(cs);
	}
}
