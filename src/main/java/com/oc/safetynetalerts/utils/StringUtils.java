/**
 * 
 */
package com.oc.safetynetalerts.utils;

/**
 * @author gareth
 *
 */
public class StringUtils {
	public static String concatNames(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		sb.append(" ");
		sb.append(str2);
		return sb.toString();
	}
}
