package com.flchy.cloud.enums;

/**
 * 删除标识枚举类型
 *

 */
public enum DelFlagEnum {

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

    DelFlagEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    /**
     * 根据value获取枚举
     *
     * @param value
     * @return
     */
    public static DelFlagEnum getByValue(Integer value) {
        if (value != null) {
            for (DelFlagEnum delFlagEnum : DelFlagEnum.values()) {
                if (delFlagEnum.value.equals(value)) {
                    return delFlagEnum;
                }
            }
        }
        return null;
    }

}
