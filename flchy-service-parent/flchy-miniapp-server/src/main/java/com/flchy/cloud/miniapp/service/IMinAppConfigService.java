package com.flchy.cloud.miniapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flchy.cloud.miniapp.bean.MinAppConfig;
import com.flchy.cloud.miniapp.enums.MimiAppTypeEnum;

import java.util.List;

/**
 * <p>
 * 小程序配置 服务类
 * </p>
 *
 * @author nieqs
 * @since 2020-01-14
 */
public interface IMinAppConfigService extends IService<MinAppConfig> {


    List<MinAppConfig> queryAll(MimiAppTypeEnum mimiAppTypeEnum);

    MinAppConfig queryByAppId(String appId);
}
