package com.flchy.cloud.miniapp.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author nieqs
 * @date 2019/9/27
 * @description 用户信息
 */
@Data
public class MiniappSessionVo implements Serializable {
    @ApiModelProperty(value = "openId",hidden = true)
    private String openId;
    @ApiModelProperty(value = "昵称",hidden = true)
    private String nickName;
    @ApiModelProperty(value = "//性别 0：未知、1：男、2：女",hidden = true)
    private String gender;
    @ApiModelProperty(value = "语言",hidden = true)
    private String language;
    @ApiModelProperty(hidden = true)
    private String city;
    @ApiModelProperty(hidden = true)
    private String province;
    @ApiModelProperty(hidden = true)
    private String country;
    @ApiModelProperty(hidden = true)
    private String avatarUrl;
    @ApiModelProperty(name = "unionid", value = "unionid",hidden = true)
    private String unionId;
    @ApiModelProperty(hidden = true)
    private String sessionKey;
    @ApiModelProperty(value = "当前AppID",hidden = true)
    private String appId;




}
