package com.flchy.cloud.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nieqs
 * @date 2019/10/30
 * @description 统一异常
 */
public enum  BaseEWarning implements EWarning {

    SYSTEM_BUSY(-1, "系统繁忙~请稍后再试~"),
    /**
     * 动态错误
     */
    Error(99, "动态错误"),
    SERVER_ERROR(98, "事务后置操作*必须*在一个活跃的事务中"),

    Unknown(1000, "未知错误"),
    ErrorParams(1001, "缺少必要参数"),

    //jwt token 相关 start
    JWT_TOKEN_EXPIRED(40001, "会话超时，请重新登录"),
    JWT_SIGNATURE(40002, "不合法的token，请认真比对 token 的签名"),
    JWT_ILLEGAL_ARGUMENT(40003, "缺少token参数"),
    JWT_GEN_TOKEN_FAIL(40004, "生成token失败"),
    JWT_PARSER_TOKEN_FAIL(40005, "解析token失败"),
    JWT_USER_INVALID(40006, "用户名或密码错误"),
    JWT_USER_ENABLED(40007, "用户已经被禁用！"),
    //jwt token 相关 end
    ;

    protected int value;
    protected String name;

    BaseEWarning() {
    }

    BaseEWarning(int value, String name) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private static Map<Integer, BaseEWarning> map = new HashMap<Integer, BaseEWarning>();

    static {
        for (BaseEWarning warning : BaseEWarning.values()) {
            map.put(warning.getValue(), warning);
        }
    }

    public static BaseEWarning getEwarning(Integer value) {
        return map.get(value);
    }
}
