package com.flchy.cloud.utils;


import com.flchy.cloud.enums.BaseEWarning;
import com.flchy.cloud.enums.EWarning;
import com.flchy.cloud.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * 
 * @author yuri
 *	2019年4月26日	下午4:43:06
 */
public class CommonUtils {

	/**
	 * 生成32位UUID
	 * 
	 * @return
	 */
	public static String generatorUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 检查非空参数
	 * 
	 * @param objects
	 */
	public static void checkParams(Object... objects) {
		for (Object object : objects) {
			if (object == null || "".equals(object)){
				throw new BusinessException(BaseEWarning.ErrorParams);
			}
		}
	}
	
	/**
	 * 
	 * @param flag
	 * @param e
	 */
	public static void throwBusinessException(boolean flag, EWarning e) {
		if(flag){
			throw new BusinessException(e);
		}
	}

	/**
	 * 获取6位数字随机验证码
	 * 
	 * @return
	 */
	public static String verifycodeGenerator() {
		int code = ((int) (Math.random() * (900000)) + 100000);
		return String.valueOf(code);
	}

	/**
	 * 获取某天的开始时间
	 * 
	 * @param date
	 * @param add
	 * @return
	 */
	public static Date getSomeDay(Date date, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, add);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

/**
 * 在某个时间点上加减多少时间
 * @param date	任意时间
 * @param field year=1,month=2,day_of_month=5,hour_of_day=11,minute=12
 * @param add 增加或减少的数量
 * @return
 */
	public static Date getSomeTime(Date date, int field, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (field) {
		case Calendar.YEAR:
			cal.add(Calendar.YEAR, add);
			break;
		case Calendar.MONTH:
			cal.add(Calendar.MONTH, add);
			break;
		case Calendar.DAY_OF_MONTH:
			cal.add(Calendar.DAY_OF_MONTH, add);
			break;
		case Calendar.HOUR_OF_DAY:
			cal.add(Calendar.HOUR_OF_DAY, add);
			break;
		case Calendar.MINUTE:
			cal.add(Calendar.MINUTE, add);
			break;
		case Calendar.SECOND:
			cal.add(Calendar.SECOND, add);
			break;
		}
		return cal.getTime();
	}

	/**
	 * 获取客户端地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (!StringUtil.isNullOrEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (!StringUtil.isNullOrEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	public static SortedMap<String,String> getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map<String,String[]> properties = request.getParameterMap();
		// 返回值Map
		SortedMap<String,String> returnMap = new TreeMap<String,String>();
		Iterator<Map.Entry<String,String[]>> entries = properties.entrySet().iterator();
		Map.Entry<String,String[]> entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry<String,String[]>) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value.trim());
		}
		// returnMap.remove("method");
		return returnMap;
	}

	public static void main(String[] args) {
		checkParams();
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
		
		Date someTime = getSomeTime(new Date(), 12, -2);
		System.out.println(someTime.toString());
	}
	
    public static String generateSignature(final Map<String, String> data, String key) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        return MD5(sb.toString()).toUpperCase();
    }   
    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }


	private static AtomicInteger counter = new AtomicInteger(0);

	/**
	 * 生成十一位纯数字ID
	 * 
	 * @return
	 */
	public static long getAtomicCounter() {
		if (counter.get() > 999999) {
			counter.set(1);
		}
		long time = Long.parseLong((new Date().getTime() + "").subSequence(5, 13).toString());
		long returnValue = time * 100 + counter.incrementAndGet();
		return returnValue;
	}


	/**
	 * 卡号补0
	 * @param cardNo
	 * @return
	 */
	public static String cardNoRepair(String cardNo){
		if(cardNo.trim().length()<10){
			int count = 10 - cardNo.trim().length();
			String key="";
			for (int i=0;i<count;i++){
				key+="0";
			}
			cardNo=key.trim()+cardNo;
		}
		return cardNo;
	}


	public static boolean isChineseWord(String str) {
		String pattern = "[\u4e00-\u9fa5]+";
		boolean isMatch = Pattern.matches(pattern, str);
		return isMatch;
	}
}
