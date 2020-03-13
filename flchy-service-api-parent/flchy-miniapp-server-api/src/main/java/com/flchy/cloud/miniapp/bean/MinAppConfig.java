package com.flchy.cloud.miniapp.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 小程序配置
 * </p>
 *
 * @author nieqs
 * @since 2020-01-15
 */
public class MinAppConfig implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * secret
     */
    private String secret;

    /**
     * aesKey
     */
    private String aesKey;

    /**
     * token
     */
    private String token;

    /**
     * 消息格式
     */
    private String msgDataFormat;

    /**
     * 类型：1微信公众号2微信小程序3微信企业号/企业微信
     */
    private Integer type;

    /**
     * 名称：小程序名称，公众号名称等
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态：1-有效 0-无效 -999-删除
     */
    private Integer commonStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsgDataFormat() {
        return msgDataFormat;
    }

    public void setMsgDataFormat(String msgDataFormat) {
        this.msgDataFormat = msgDataFormat;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(Integer commonStatus) {
        this.commonStatus = commonStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MinAppConfig{" +
                "id=" + id +
                ", secret=" + secret +
                ", aesKey=" + aesKey +
                ", token=" + token +
                ", msgDataFormat=" + msgDataFormat +
                ", type=" + type +
                ", name=" + name +
                ", remark=" + remark +
                ", commonStatus=" + commonStatus +
                ", createTime=" + createTime +
                "}";
    }
}
