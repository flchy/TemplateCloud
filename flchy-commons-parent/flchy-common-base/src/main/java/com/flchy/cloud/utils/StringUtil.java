package com.flchy.cloud.utils;


import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author nieqs
 * @date 2019/9/22
 * @description 字符串验证
 */
public class StringUtil extends StringUtils {
    public static boolean isNullOrEmpty(Object str) {
        return isNullOrEmpty(String.valueOf(str));
    }
    /**
     * 判断字符串是否为空或为空值。<br/>
     * 详细描述：判断字符串是否为空或为空值。<br/>
     * 使用方式：通过本类的类名直接调用该方法，并传入所需参数。<br/>
     *
     * @param str 字符串。<br/>
     * @return flag true表示参数是为空或为空值，false则表示不为空或空值。<br/>
     */
    public static boolean isNullOrEmpty(String str) {
        boolean flag = false;
        if (null == str || "".equals(str.trim()) || "n/a".equals(str.trim().toLowerCase()) || "[]".equals(str.trim().toLowerCase())  || "null".equals(str.trim().toLowerCase()) || "undefined".equals(str.trim().toLowerCase())) {
            flag = true;
        }
        return flag;
    }

    /**
     * 批量判断是否为空
     * @param strs
     * @return
     */
    public static boolean isNullOrEmpty(String[] strs) {
        boolean flag = false;
        if (null != strs && strs.length > 0) {
            for (String str : strs) {
                if (null == str || "".equals(str.trim()) || "n/a".equals(str.trim().toLowerCase()) || "null".equals(str.trim().toLowerCase()) || "undefined".equals(str.trim().toLowerCase())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }


    /**
     * 判断是否为空
     * @param strs
     * @return
     */
    public static boolean isNullOrEmpty(byte[] strs) {
        boolean flag = true;
        if (null != strs && strs.length > 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否为空
     * @param strs
     * @return
     */
    public static boolean isNullOrEmpty(Set<String> strs) {
        boolean flag = true;
        if (null != strs && !strs.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    /**
     * 批量判断是否为空
     * @param strs
     * @return
     */
    public static boolean isNullOrEmpty(List<String> strs) {
        boolean flag = false;
        if (null != strs && strs.size() > 0) {
            for (String str : strs) {
                if (null == str || "".equals(str.trim()) || "n/a".equals(str.trim().toLowerCase()) || "null".equals(str.trim().toLowerCase()) || "undefined".equals(str.trim().toLowerCase())) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 产生6位随机数(000000-999999)
     *
     * @return 6位随机数
     */
    public static String getSixRandom() {
        Random random = new Random();
        String sixRandom = random.nextInt(999999) + "";
        int randLength = sixRandom.length();
        if (randLength < 6) {
            for (int i = 1; i <= 6 - randLength; i++)
                sixRandom = "0" + sixRandom;
        }
        return sixRandom;
    }
}
