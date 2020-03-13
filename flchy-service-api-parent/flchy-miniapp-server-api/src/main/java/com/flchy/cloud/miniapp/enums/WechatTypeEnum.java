package com.flchy.cloud.miniapp.enums;

import java.util.Arrays;

/**
 * @author nieqs
 * @date 2019/9/27
 * @description 微信用户类型10 公众号 20小程序 30 小游戏 40 企业微信
 */
public enum WechatTypeEnum {

    PUBLIC(10,"公众号"),
    MINI_APP(20,"小程序"),
    MINI_GAME(30,"小游戏"),
    ENTERPRISE(40,"企业微信")
    ;
    private String key;
    private Integer value;

    WechatTypeEnum(Integer value, String key) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static WechatTypeEnum getEnum(Integer value) {
        return Arrays.asList(WechatTypeEnum.values()).stream().filter(l -> l.getValue().equals(value)).findFirst().orElse(null);
    }
}
