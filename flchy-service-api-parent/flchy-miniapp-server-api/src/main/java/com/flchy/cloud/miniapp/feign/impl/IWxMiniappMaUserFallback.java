package com.flchy.cloud.miniapp.feign.impl;

import com.flchy.cloud.enums.BaseEWarning;
import com.flchy.cloud.miniapp.feign.IWxMiniappMaUserClient;
import com.flchy.cloud.miniapp.vo.MiniappSessionVo;
import com.flchy.cloud.miniapp.vo.WechatLoginVo;
import com.flchy.cloud.response.ResponseResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
@Slf4j
public class IWxMiniappMaUserFallback implements FallbackFactory<IWxMiniappMaUserClient> {
    @Override
    public IWxMiniappMaUserClient create(Throwable throwable) {
        return new IWxMiniappMaUserClient() {
            @Override
            public ResponseResult<MiniappSessionVo> login(String appid, @Valid WechatLoginVo vo) {
                return new ResponseResult(BaseEWarning.SYSTEM_BUSY);
            }

        };
    }
}
