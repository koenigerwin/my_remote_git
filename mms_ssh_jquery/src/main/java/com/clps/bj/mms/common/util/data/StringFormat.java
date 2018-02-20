/**
 * 
 */
package com.clps.bj.mms.common.util.data;

/**
 * 
 * @author erwin.wang
 *
 * 2017年12月19日下午5:03:20
 */
public class StringFormat {
	
	/**
	 * 判断字符串是否为字母的。
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}
	/**
	 * 判断是否为汉字
	 * 
	 * @param str
	 * @return boolean
	 */
	public boolean checkGBK(String str) {
		char[] chars = str.toCharArray();
		boolean isGB2312 = false;
		for (int i = 0; i < chars.length; i++) {
			byte[] bytes = ("" + chars[i]).getBytes();
			if (bytes.length == 2) {
				int[] ints = new int[2];
				ints[0] = bytes[0] & 0xff;
				ints[1] = bytes[1] & 0xff;
				if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE) {
					isGB2312 = true;
					break;
				}
			}
		}
		return isGB2312;
	}
}
