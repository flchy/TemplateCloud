package com.flchy.cloud.context;



import com.flchy.cloud.utils.NumberHelper;
import com.flchy.cloud.utils.StrHelper;

import java.util.HashMap;
import java.util.Map;


/**
 * 获取当前域中的 用户id appid 用户昵称
 * 注意： appid 通过token解析，  用户id 和 用户昵称必须在前端 通过请求头的方法传入。 否则这里无法获取
 */
public class BaseContextHandler {
    private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(String key, Long value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? "0" : String.valueOf(value));
    }

    public static void set(String key, String value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? "" : value);
    }

    public static void set(String key, Boolean value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? "false" : value.toString());
    }


    public static Map<String, String> getLocalMap() {
        Map<String, String> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(10);
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void setLocalMap(Map<String, String> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }


    public static String get(String key) {
        Map<String, String> map = getLocalMap();
        return map.getOrDefault(key, "");
    }

    public static Boolean isBoot() {
        Object value = get(BaseContextConstant.IS_BOOT);
        return NumberHelper.boolValueOf0(value);
    }

    /**
     * 账号id
     *
     * @param val
     */
    public static void setBoot(Boolean val) {
        set(BaseContextConstant.IS_BOOT, val);
    }

    /**
     * 账号id
     *
     * @return
     */
    public static Long getUserId() {
        Object value = get(BaseContextConstant.JWT_KEY_USER_ID);
        return NumberHelper.longValueOf0(value);
    }

    /**
     * 账号id
     *
     * @param userId
     */
    public static void setUserId(Long userId) {
        set(BaseContextConstant.JWT_KEY_USER_ID, userId);
    }

    public static void setUserId(String userId) {
        setUserId(NumberHelper.longValueOf0(userId));
    }

    /**
     * 账号表中的name
     *
     * @return
     */
    public static String getAccount() {
        Object value = get(BaseContextConstant.JWT_KEY_ACCOUNT);
        return returnObjectValue(value);
    }

    /**
     * 账号表中的name
     *
     * @param name
     */
    public static void setAccount(String name) {
        set(BaseContextConstant.JWT_KEY_ACCOUNT, name);
    }


    /**
     * 登录的账号
     *
     * @return
     */
    public static String getName() {
        Object value = get(BaseContextConstant.JWT_KEY_NAME);
        return returnObjectValue(value);
    }

    /**
     * 登录的账号
     *
     * @param account
     */
    public static void setName(String account) {
        set(BaseContextConstant.JWT_KEY_NAME, account);
    }

    /**
     * 获取用户token
     *
     * @return
     */
    public static String getToken() {
        Object value = get(BaseContextConstant.TOKEN_NAME);
        return StrHelper.getObjectValue(value);
    }

    public static void setToken(String token) {
        set(BaseContextConstant.TOKEN_NAME, token);
    }

    public static String getOrgId() {
        Object value = get(BaseContextConstant.JWT_KEY_ORG_ID);
        return StrHelper.getObjectValue(value);
    }

    public static void setOrgId(String val) {
        set(BaseContextConstant.JWT_KEY_ORG_ID, val);
    }

    public static Integer getOrgType() {
        Object value = get(BaseContextConstant.JWT_KEY_ORG_TYPE);
        return NumberHelper.intValueOf0(value);
    }

    public static void setOrgType(String val) {
        set(BaseContextConstant.JWT_KEY_ORG_TYPE, val);
    }


    public static Integer getLoginType() {
        Object value = get(BaseContextConstant.JWT_KEY_LOGIN_TYPE);
        return NumberHelper.intValueOf0(value);
    }

    public static void setLoginType(String val) {
        set(BaseContextConstant.JWT_KEY_LOGIN_TYPE, val);
    }
    public static Boolean getIsTourist() {
        Object value = get(BaseContextConstant.JWT_KEY_IS_TOURIST);
        return Boolean.valueOf(String.valueOf(value));
    }

    public static void setIsTourist(String val) {
        set(BaseContextConstant.JWT_KEY_IS_TOURIST, val);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? "" : value.toString();
    }

    public static void remove() {
        if (THREAD_LOCAL != null) {
            THREAD_LOCAL.remove();
        }
    }

}
