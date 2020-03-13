package com.flchy.cloud.miniapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flchy.cloud.miniapp.bean.WechatUser;
import com.flchy.cloud.miniapp.vo.MiniappSessionVo;

/**
 * <p>
 * 微信用户信息 服务类
 * </p>
 *
 * @author nieqs
 * @since 2019-09-27
 */
public interface IWechatUserService extends IService<WechatUser> {

    void editMiniAppUser(MiniappSessionVo miniappSessionVo);
}
