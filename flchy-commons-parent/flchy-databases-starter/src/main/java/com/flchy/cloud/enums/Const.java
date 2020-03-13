package com.flchy.cloud.enums;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author nieqs
 * @date 2019/9/27
 * @description 公共
 */
public class Const {
    public static String MINITOKEN = "miniappToken";
    /**
     * TODO 暂时写死 这个版本先
     */
    public static Integer schoolId = 1;
    public static List<String> MINIAPP_IGNORE_URL = Lists.newArrayList("/teacher/findTeacherAudit","/teacher/register","/teacher/registerRemind","/parent/register");
}
