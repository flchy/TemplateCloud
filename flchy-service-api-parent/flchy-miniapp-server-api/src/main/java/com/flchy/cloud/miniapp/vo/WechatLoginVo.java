package com.flchy.cloud.miniapp.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author nieqs
 * @date 2019/9/28
 * @description 微信登录
 */
@Data
@ApiModel( description = "微信登录")
public class WechatLoginVo {
    @NotEmpty(message = "code不能为空")
    private String code;
    @NotEmpty(message = "signature不能为空")
    private String signature;
    @NotEmpty(message = "rawData不能为空")
    private String rawData;
    @NotEmpty(message = "encryptedData不能为空")
    private String encryptedData;
    @NotEmpty(message = "iv不能为空")
    private String iv;
}
