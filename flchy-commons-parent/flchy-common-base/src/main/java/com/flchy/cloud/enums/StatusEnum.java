package com.flchy.cloud.enums;

import java.util.Arrays;

/**
 * 数据状态枚举公用
 */
public enum StatusEnum {

    /**
     * 删除
     */
    DEL_FLAG_ENUM_DEL(-999),
    /**
     * 有效
     */
    DEL_FLAG_ENUM_VALID(1),
    /**
     * 无效
     */
    DEL_FLAG_ENUM_INVALID(0);

    private Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }


    public static StatusEnum getEnum(Integer value) {
        return Arrays.asList(StatusEnum.values()).stream().filter(l -> l.getValue().equals(value)).findFirst().orElse(null);
    }

}
