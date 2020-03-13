package com.flchy.cloud.context;

/**
 * 常量工具类
 *
 * @author zuihou
 * @date 2018/12/21
 */
public class BaseContextConstant {
    /**
     *
     */
    public static final String TOKEN_NAME = "token";
    /**
     *
     */
    public static final String JWT_KEY_USER_ID = "userid";
    /**
     *
     */
    public static final String JWT_KEY_NAME = "name";
    /**
     *
     */
    public static final String JWT_KEY_ACCOUNT = "account";

    /**
     * 当前登录人其他信息
     */
    public static final String JWT_KEY_ORG_ID = "orgid";
    /**
     * 当前登录用户类型
     */
    public static final String JWT_KEY_ORG_TYPE = "orgType";

    /**
     * 登录类型
     */
    public static final String JWT_KEY_LOGIN_TYPE = "loginType";

    public static final String JWT_KEY_IS_TOURIST= "isTourist";

    public static final String IS_BOOT = "boot";
    /**
     * 请求头名称
     */
    public static final String HEADER_NAME="token";
    /**
     * 过期时间
     */
    public static final Integer expire=43200;

    /**
     * 解密 网关使用
     */
    public static final String PUB_KEY="client/pub.key";
    /**
     * 加密 服务使用
     */
    public static final String PRI_KEY="client/pri.key";

}
