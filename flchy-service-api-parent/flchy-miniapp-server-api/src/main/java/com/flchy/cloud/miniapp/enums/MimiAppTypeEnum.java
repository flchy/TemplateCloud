package com.flchy.cloud.miniapp.enums;

import com.flchy.cloud.enums.StatusEnum;

import java.util.Arrays;

/**
 * @Auther: 24845
 * @Date: 2019/6/28 11:07
 * @Description: 小程序类型
 */
public enum MimiAppTypeEnum {
    WECHAT_PUBLIC(1,"微信公众号"),
    WECHAT_APP(2,"微信小程序"),
    WECHAT_ENTERPRISE(3,"微信企业号/企业微信"),
    ;
    private String key;
    private Integer value;

    MimiAppTypeEnum(Integer value, String key) {
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

    public static StatusEnum getEnum(Integer value) {
        return Arrays.asList(StatusEnum.values()).stream().filter(l -> l.getValue().equals(value)).findFirst().orElse(null);
    }

}