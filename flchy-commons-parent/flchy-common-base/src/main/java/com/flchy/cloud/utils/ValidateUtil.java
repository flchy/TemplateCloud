package com.flchy.cloud.utils;

import java.util.Collection;

public class ValidateUtil {
    /**
     * collection不可为空的校验
     *
     * @param data
     * @return
     */
    public static boolean collectionNotEmpty(Collection<?> data) {
        boolean result = false;
        if (data != null && data.size() > 0) {
            result = true;
        }
        return result;
    }

    /**
     * collection可为空的校验
     *
     * @param data
     * @return
     */
    public static boolean collectionEmpty(Collection<?> data) {
        return !collectionNotEmpty(data);
    }
}
