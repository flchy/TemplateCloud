package com.flchy.cloud.enums;

import java.util.Arrays;

/**
 * @Auther: 24845
 * @Date: 2019/6/28 11:07
 * @Description: 硬件类型
 */
public enum HardwareTypeEnum {
    GATE(10, "闸机"),
    CAMERA(20, "摄像头"),
    ATTENDANCE(30, "一卡通考勤机"),

    ;
    private String key;
    private Integer value;

    HardwareTypeEnum(Integer value, String key) {
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

    public static HardwareTypeEnum getEnum(Integer value) {
        return Arrays.asList(HardwareTypeEnum.values()).stream().filter(l -> l.getValue().equals(value)).findFirst().orElse(null);
    }

}