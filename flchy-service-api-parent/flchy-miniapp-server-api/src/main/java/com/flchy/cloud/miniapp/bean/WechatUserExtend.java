package com.flchy.cloud.miniapp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 多微信小程序  微信公众号关联表
 * </p>
 *
 * @author nieqs
 * @since 2019-09-27
 */
public class WechatUserExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 微信用户信息ID
     */
    private Integer wechatUserId;

    /**
     * 公众号或小程序等AppID
     */
    private String appId;

    /**
     * 用户类型10 公众号 20小程序 30 小游戏 40 企业微信
     */
    private Integer type;

    /**
     * 微信openid
     */
    private String openId;

    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    private Integer groupId;

    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    private LocalDateTime subscribeTime;

    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    private String remark;

    /**
     * 用户被打上的标签ID列表
     */
    private String tagidList;

    /**
     * 用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENE_PROFILE_ LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
     */
    private String subscribeScene;

    /**
     * 二维码扫码场景（开发者自定义）
     */
    private String qrScene;

    /**
     * 二维码扫码场景描述（开发者自定义）
     */
    private String qrSceneStr;

    /**
     * 用户是否关注 10 关注 20取消关注
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWechatUserId() {
        return wechatUserId;
    }

    public void setWechatUserId(Integer wechatUserId) {
        this.wechatUserId = wechatUserId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }



    public LocalDateTime getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(LocalDateTime subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTagidList() {
        return tagidList;
    }

    public void setTagidList(String tagidList) {
        this.tagidList = tagidList;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    public String getQrScene() {
        return qrScene;
    }

    public void setQrScene(String qrScene) {
        this.qrScene = qrScene;
    }

    public String getQrSceneStr() {
        return qrSceneStr;
    }

    public void setQrSceneStr(String qrSceneStr) {
        this.qrSceneStr = qrSceneStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WechatUserExtend{" +
        "id=" + id +
        ", wechatUserId=" + wechatUserId +
        ", appId=" + appId +
        ", type=" + type +
        ", openId=" + openId +
        ", groupId=" + groupId +
        ", subscribeTime=" + subscribeTime +
        ", remark=" + remark +
        ", tagidList=" + tagidList +
        ", subscribeScene=" + subscribeScene +
        ", qrScene=" + qrScene +
        ", qrSceneStr=" + qrSceneStr +
        ", status=" + status +
        "}";
    }
}
