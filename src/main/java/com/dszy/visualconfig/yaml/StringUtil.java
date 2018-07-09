/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dszy.visualconfig.yaml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class StringUtil {
	
	 private static Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	private static String[] s = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
		"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    public StringUtil() {
    }

    public static String substring(String str, int sublen) {
        if (str == null || sublen <= 0) {
            return str;
        } else {
            StringBuilder buf = new StringBuilder(sublen);
            int totalLen = 0;
            char[] charArrays = str.toCharArray();
            for (char ch : charArrays) {
                if (ch > 32 && ch < 127) {
                    totalLen += 1;
                    if (totalLen <= sublen) {
                        buf.append(ch);
                    }
                } else {
                    totalLen += 2;
                    if (totalLen <= sublen) {
                        buf.append(ch);
                    }
                }
                if (totalLen > sublen) {
                    break;
                }
            }
            return buf.toString();
        }
    }
    /**
	 * @description 生成指定位数的字符串
	 * @param length
	 * @return String
	 */
	public static String getRandomString(int length) {
		String rs = "";
		int i = 0;
		Random r = new Random();
		while (i < length) {
			int j = r.nextInt(s.length);
			rs += s[j];
			i++;
		}
		return rs;
	}
	
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isNullForString(String str) {
		return str == null || "".equals(str.trim());
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return isNullForString(str);
	}

	/**
	 * 判断参数序列是否有空
	 * 
	 * @param params
	 * @return boolean
	 * @author:朱江铭
	 * @date:2012-3-28
	 */
	public static boolean isExistNull(String... params) {
		boolean flag = false;
		for (String str : params) {
			if (null == str || "".equals(str)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
     * Function:判断字符串是否为空或零长
     * @param str 待检查的字符串变量
     * @return true  字符串为空或零长
     *         false 字符串不为空且不是零长字符串
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final String str) {
		return (str == null) || (str.trim().length() <= 0);
	}

	/**
     * Function:判断字符是否为空或空格
     * @param cha 待检查的字符变量
     * @return true  字符为空或空格
     *         false 字符不为空且不是空格
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Character cha){
		return (cha==null) || cha.equals(' ');
	}

	/**
     * Function:判断对象是否为空
     * @param obj 待检查的对象变量
     * @return true  对象为空
     *         false 对象不为空
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Object obj) {
		return (obj==null);
	}

	/**
     * Function:判断对象数组是否为空或无元素
     * @param objs 待检查的对象数组变量
     * @return true  对象数组为空或无元素
     *         false 对象数组不为空且有元素
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Object[] objs) {
		return (objs == null) || (objs.length <= 0);
	}

	/**
     * Function:判断集合对象是否为空或无元素
     * @param obj 待检查的集合对象变量
     * @return true  集合对象为空或无元素
     *         false 集合对象不为空且有元素
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Collection obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
     * Function:判断Set对象是否为空或无元素
     * @param obj 待检查的Set对象变量
     * @return true  Set对象为空或无元素
     *         false Set对象不为空且有元素
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Set obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
     * Function:判断Serializable对象是否为空
     * @param obj 待检查的Serializable对象变量
     * @return true  Serializable对象为空
     *         false Serializable对象不为空
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Serializable obj) {
		return obj == null;
	}

	/**
     * Function:判断Map对象是否为空或无元素
     * @param obj 待检查的Map对象变量
     * @return true  Map对象为空或无元素
     *         false Map对象不为空且有元素
     * Create author:
     * Create on:2008-01-21
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Map obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
     * Function:判断Long对象是否为空
     * @param obj 待检查的Long对象变量
     * @return true  Long对象为空
     *         false Long对象不为空且有元素
     * Create author:xuhaidui
     * Create on:2008-06-12
     * Edit author:
     * Edit on:
     * Why:
     */
	public static boolean isBlank(final Long obj) {
		return obj == null;
	}
	/**
	 * 验证用户格式
	 * 
	 * @param userId
	 * @return
	 * @author:jinjia
	 * @date:2013-3-29
	 */
	public static boolean validateUserId(String userId){
		if(userId==null || "".equals(userId)){
			return false;
		}
		Pattern pattern=Pattern.compile("^[A-Za-z]{1}[A-Za-z0-9]{5,14}$");
		Matcher matcher=pattern.matcher(userId);
		boolean isTrue=matcher.matches();
		return isTrue;
	}
	/**
	 * 验证邮箱格式
	 * 
	 * @param email
	 * @return
	 * @author:jinjia
	 * @date:2013-3-29
	 */
	public static boolean validateEamil(String email){
		if(email==null || "".equals(email)){
			return false;
		}
		Pattern pattern=Pattern.compile("^[A-Za-z0-9+_-]+@[A-Za-z0-9+_-]+\\.[A-Za-z0-9+_-]+");
		Matcher matcher=pattern.matcher(email);
		boolean isTrue=matcher.matches();
		return isTrue;
	}

	
	
	/**
	 * 比较字符串是否符合正则表达式规则
	 * 
	 * @param regEx
	 *            正则表达式
	 * @param input
	 *            匹配字符串
	 * @return
	 */
	public static boolean matcher(String regEx, String input) {
		if (input != null && !"".equals(input)) {
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(input);
			return m.matches();
		} else {
			return false;
		}
	}


	/**
	 * 解压
	 * 
	 * @param input
	 * @return
	 */
	public static byte[] decompress(byte[] input) {
		byte[] output = new byte[0];
		Inflater decompresser = new Inflater();
		decompresser.reset();
		decompresser.setInput(input);
		ByteArrayOutputStream o = new ByteArrayOutputStream(input.length);
		try {
			byte[] buf = new byte[1024];
			while (!decompresser.finished()) {
				int i = decompresser.inflate(buf);
				o.write(buf, 0, i);
			}
			output = o.toByteArray();
		} catch (Exception e) {
			output = input;
			log.error("系统异常",e);
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				log.error("系统异常",e);
			}
		}
		decompresser.end();
		return output;
	}

	/**
	 * 压缩
	 * 
	 * @param input
	 * @return
	 */
	public static byte[] compress(byte[] input) {
		byte[] output = new byte[0];
		Deflater compresser = new Deflater();
		compresser.reset();
		compresser.setInput(input);
		compresser.finish();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(input.length);
		try {
			byte[] buf = new byte[1024];
			while (!compresser.finished()) {
				int i = compresser.deflate(buf);
				bos.write(buf, 0, i);
			}
			output = bos.toByteArray();
		} catch (Exception e) {
			output = input;
			log.error("系统异常",e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				log.error("系统异常",e);
			}
		}
		compresser.end();
		return output;
	}

	/**
	 * 
	 * 功能说明：将字节转换成字符串 参数及返回值:
	 * 
	 * @return
	 * @throws
	 */
	public static String byteArr2HexStr(byte[] arrB) {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			} // 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 
	 * 功能说明：将字符串转换成字节 参数及返回值:
	 * 
	 * @return
	 * @throws
	 */
	public static byte[] hexStr2ByteArr(String strIn) {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	public static String MD5(String str) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(str.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	public static String doReplace(String str) {
		return str.replaceAll("\\{","").replaceAll("\\}","").replaceAll("\\(","").replaceAll("\\)","");
	}
	public static boolean doCheck(String str) {
		boolean returnCode=false;
		if(str.indexOf("{")!=-1 && str.indexOf("}")!=-1 &&str.indexOf("(")!=-1 &&str.indexOf(")")!=-1){
			returnCode=true;
		}
		return returnCode;
	}

	/**
	 * 将传入的数字转换成以逗号分隔的形式，如传入123456789，转换成123,456,789
	 * @author wednesday
	 * @param number
	 * @return
	 */
	public static String getShowNumber(long number){
		//如果是负数，取正
		boolean bellowzero = false;
		if(number<0){
			bellowzero=true;
			number=-number;
		}
		StringBuilder sb = new StringBuilder(number+"");
		//根据数字的大小决定循环几次
		int count = (sb.length()-1)/3;
		int mod = sb.length()%3==0?3:sb.length()%3;
		for (int i = 1; i <= count; i++) {
			sb.insert(mod+3*(count-i), ",");
		}
		if(bellowzero){
			sb.insert(0, "-");
		}
		return sb.toString();
	}
	public static String getRandomString(String tempStr, int length) {
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = tempStr.length();
		for (int i = 0; i < length; i++) {
			sb.append(tempStr.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	
	/**
	 * 将一个字符串解析为long数字, 当遇到无法解析的字符串时(空字符或者空白字符串等)返回0
	 * @param str
	 * @return
	 */
	public static long parseLong(String str) {
		try {
			return Long.parseLong(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
	
	public static String formatDouble(String iNumber) {
		DecimalFormat decFormat;
		String sFormat = "#,##0.00";
		String sNumber = "";
		try {
			decFormat = new DecimalFormat(sFormat);
			sNumber = decFormat.format(Double.parseDouble(iNumber));
		} catch (Exception e) {
			//System.out.println("Exception: " + e.getMessage());
		}
		return sNumber;
	}
	
	public static String formatMoney(String iNumber) {
		DecimalFormat decFormat;
		String sFormat = "####.00";
		String sNumber = "";
		try {
			decFormat = new DecimalFormat(sFormat);
			sNumber = decFormat.format(Double.parseDouble(iNumber));
		} catch (Exception e) {
			//System.out.println("Exception: " + e.getMessage());
		}
		return sNumber;
	}
	
	/**
	 * @description 生成指定位数的随机数
	 * @param length
	 * @return String
	 */
	public static String getRandomDigit(int length) {
		StringBuffer rs = new StringBuffer();
		int i = 0;
		Random random = new Random();
		while (i < length) {
			rs.append(random.nextInt(9));
			i++;
		}
		return rs.toString();
	}
	
	/**
	 * 只要有一个参数为空则为空
	 * 
	 * @param values
	 * @return
	 * @author:jzy
	 * @date:2011-12-9
	 */
	public static boolean isNull(Object... values) {
		if (values == null) {
			return true;
		}
		for (Object value : values) {
			if (value == null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 只要有一个参数为空则为空
	 * 
	 * @param values
	 * @return
	 * @author:jzy
	 * @date:2011-12-9
	 */
	public static boolean isNull(String... values) {
		if (values == null || values.length == 0) {
			return true;
		}

		for (String value : values) {
			if (value == null || "".equals(value.trim())) {
				return true;
			}
		}

		return false;
	}
	
	@SuppressWarnings("finally")
	public static String isoString(String s) {
		String s2 = s;
		try {
			s2 = new String(s.getBytes("GB2312"), "iso-8859-1");
		} catch (Exception e) {
		} finally {
			return s2;
		}
	}
	
	public static String nullToString(String inString) {
		return (inString == null ? "" : inString.trim());
	}
	
	/**
	 * 将Map元素组装成URL形式的字符串
	 * 
	 * @param map
	 * @return
	 * @author:jzy
	 * @date:2011-12-17
	 */
	public static String map2URLString(Map<String, String[]> map) {
		return createLinkString(mapValueArray2String(map));
	}
	
	/**
	 * 转换Map<String, String[]> to Map<String, String>
	 * 
	 * @param map
	 *            <String, String[]>
	 * @return Map<String, String>
	 * @author:jzy
	 * @date:2011-12-17
	 */
	public static Map<String, String> mapValueArray2String(Map<String, String[]> map) {
		Map<String, String> params = new HashMap<String, String>();
		for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) map.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		return params;
	}

	
	public static String stringReplace(String oldStr, String searchStr, String replaceStr) {
		String outStr = "";
		int iPos = 0;
		int iLen = searchStr.length();

		if (oldStr == null || oldStr == "" || searchStr == null || replaceStr == null) {
			return oldStr;
		}

		iPos = oldStr.indexOf(searchStr);

		while (iPos != -1) {
			outStr += oldStr.substring(0, iPos) + replaceStr;
			iPos += iLen;
			if (oldStr.length() >= iPos) {
				oldStr = oldStr.substring(iPos);
				iPos = oldStr.indexOf(searchStr);
			}
		}
		outStr += oldStr;
		return outStr;
	}
	
	public static String fillEmpty(String s, int len) {
		StringBuilder empty = new StringBuilder("");
		for(int i = 0; i < len - s.length(); i++) {
			empty.append(" ");
		}
		return s + empty.toString();
	}
}
