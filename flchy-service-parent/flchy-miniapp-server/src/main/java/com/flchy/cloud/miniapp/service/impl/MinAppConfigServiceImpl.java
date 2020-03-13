package com.flchy.cloud.miniapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flchy.cloud.enums.StatusEnum;
import com.flchy.cloud.miniapp.bean.MinAppConfig;
import com.flchy.cloud.miniapp.dao.MinAppConfigMapper;
import com.flchy.cloud.miniapp.enums.MimiAppTypeEnum;
import com.flchy.cloud.miniapp.service.IMinAppConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 小程序配置 服务实现类
 * </p>
 *
 * @author nieqs
 * @since 2020-01-14
 */
@Service
public class MinAppConfigServiceImpl extends ServiceImpl<MinAppConfigMapper, MinAppConfig> implements IMinAppConfigService {

    @Override
    public List<MinAppConfig> queryAll(MimiAppTypeEnum mimiAppTypeEnum) {
        List<MinAppConfig> minAppConfigs = super.baseMapper.selectList(new LambdaQueryWrapper<MinAppConfig>().eq(MinAppConfig::getCommonStatus, StatusEnum.DEL_FLAG_ENUM_VALID.getValue()).eq(MinAppConfig::getType,mimiAppTypeEnum.getValue()));
        return minAppConfigs;
    }

    @Override
    public MinAppConfig queryByAppId(String appId) {
        MinAppConfig minAppConfig = super.baseMapper.selectById(appId);
        return minAppConfig;
    }
}
