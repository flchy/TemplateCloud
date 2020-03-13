package com.flchy.cloud.enums;

import java.util.Arrays;

/**
 * @author nieqs
 * @date 2019/10/3
 * @description 用户类型
 */
public enum  UserTypeEnum {
    STUDENT(10,"学生"),
    TEACHER(20,"老师"),
    PARENT(30,"家长"),

            ;
    private String key;
    private Integer value;

    UserTypeEnum(Integer value, String key) {
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

    public static UserTypeEnum getEnum(Integer value) {
        return Arrays.asList(UserTypeEnum.values()).stream().filter(l -> l.getValue().equals(value)).findFirst().orElse(null);
    }
}
