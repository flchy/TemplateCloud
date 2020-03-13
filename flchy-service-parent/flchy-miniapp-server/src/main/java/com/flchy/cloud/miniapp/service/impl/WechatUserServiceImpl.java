package com.flchy.cloud.miniapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flchy.cloud.miniapp.bean.WechatUser;
import com.flchy.cloud.miniapp.bean.WechatUserExtend;
import com.flchy.cloud.miniapp.dao.WechatUserExtendMapper;
import com.flchy.cloud.miniapp.dao.WechatUserMapper;
import com.flchy.cloud.miniapp.enums.WechatSubscribeSceneEnum;
import com.flchy.cloud.miniapp.enums.WechatTypeEnum;
import com.flchy.cloud.miniapp.service.IWechatUserService;
import com.flchy.cloud.miniapp.vo.MiniappSessionVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 微信用户信息 服务实现类
 * </p>
 *
 * @author nieqs
 * @since 2019-09-27
 */
@Service
@Slf4j
public class WechatUserServiceImpl extends ServiceImpl<WechatUserMapper, WechatUser> implements IWechatUserService {

    @Resource
    WechatUserExtendMapper wechatUserExtendMapper;

    /**
     * 小程序用户信息序列化到数据库
     *
     * @param miniappSessionVo
     */
    @Override
    public void editMiniAppUser(MiniappSessionVo miniappSessionVo) {
        //TODO 后面做异步序列化
        WechatUser wechatUsers = super.baseMapper.selectOne(new LambdaQueryWrapper<WechatUser>().eq(WechatUser::getUnionId, miniappSessionVo.getUnionId()));
        if (wechatUsers == null) {
            wechatUsers = new WechatUser();
            BeanUtils.copyProperties(miniappSessionVo, wechatUsers);
            wechatUsers.setSex(miniappSessionVo.getGender() == null ? null : Integer.valueOf(miniappSessionVo.getGender()));
            wechatUsers.setHeadImgUrl(miniappSessionVo.getAvatarUrl());
            super.save(wechatUsers);
        } else {
            int count = 0;
            WechatUser wechatUser = new WechatUser();
            if (StringUtils.isNotEmpty(miniappSessionVo.getNickName()) && !miniappSessionVo.getNickName().equals(wechatUsers.getNickName())) {
                wechatUser.setNickName(miniappSessionVo.getNickName());
                count++;
            }
            try {
                if (StringUtils.isNotEmpty(miniappSessionVo.getGender()) && !Integer.valueOf(miniappSessionVo.getGender()).equals(wechatUsers.getSex())) {
                    wechatUser.setSex(miniappSessionVo.getGender() == null ? null : Integer.valueOf(miniappSessionVo.getGender()));
                    count++;
                }
            } catch (Exception e) {

            }
            if (StringUtils.isNotEmpty(miniappSessionVo.getLanguage()) && !miniappSessionVo.getLanguage().equals(wechatUsers.getLanguage())) {
                wechatUser.setLanguage(miniappSessionVo.getLanguage());
                count++;
            }
            if (StringUtils.isNotEmpty(miniappSessionVo.getCity()) && !miniappSessionVo.getCity().equals(wechatUsers.getCity())) {
                wechatUser.setCity(miniappSessionVo.getCity());
                count++;
            }
            if (StringUtils.isNotEmpty(miniappSessionVo.getCountry()) && !miniappSessionVo.getCountry().equals(wechatUsers.getCountry())) {
                wechatUser.setCountry(miniappSessionVo.getCountry());
                count++;
            }
            if (StringUtils.isNotEmpty(miniappSessionVo.getProvince()) && !miniappSessionVo.getProvince().equals(wechatUsers.getProvince())) {
                wechatUser.setProvince(miniappSessionVo.getProvince());
                count++;
            }
            if (StringUtils.isNotEmpty(miniappSessionVo.getAvatarUrl()) && !miniappSessionVo.getAvatarUrl().equals(wechatUsers.getHeadImgUrl())) {
                wechatUser.setHeadImgUrl(miniappSessionVo.getAvatarUrl());
                count++;
            }
            if (count > 0) {
                super.baseMapper.update(wechatUser, new LambdaQueryWrapper<WechatUser>().eq(WechatUser::getUnionId, miniappSessionVo.getUnionId()));
            }
        }
        LambdaQueryWrapper<WechatUserExtend> wechatUserExtendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        wechatUserExtendLambdaQueryWrapper.eq(WechatUserExtend::getAppId, miniappSessionVo.getAppId());
        wechatUserExtendLambdaQueryWrapper.eq(WechatUserExtend::getOpenId, miniappSessionVo.getOpenId());
        List<WechatUserExtend> wechatUserExtends = wechatUserExtendMapper.selectList(wechatUserExtendLambdaQueryWrapper);
        if (wechatUserExtends == null || wechatUserExtends.size() < 1) {
            WechatUserExtend wechatUserExtend = new WechatUserExtend();
            wechatUserExtend.setAppId(miniappSessionVo.getAppId());
            wechatUserExtend.setWechatUserId(wechatUsers.getId());
            wechatUserExtend.setType(WechatTypeEnum.MINI_APP.getValue());
            wechatUserExtend.setOpenId(miniappSessionVo.getOpenId());
            wechatUserExtend.setSubscribeTime(LocalDateTime.now());
            wechatUserExtend.setSubscribeScene(WechatSubscribeSceneEnum.ADD_SCENE_OTHERS.getValue());
            wechatUserExtendMapper.insert(wechatUserExtend);
        }
        //TODO 下个版本验证数据一致性  更新  如：微信里面改了昵称  这边数据库未更新
    }

}
