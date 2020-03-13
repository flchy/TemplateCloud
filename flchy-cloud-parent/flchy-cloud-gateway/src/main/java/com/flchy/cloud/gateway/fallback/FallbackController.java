package com.flchy.cloud.gateway.fallback;


import com.flchy.cloud.enums.BaseEWarning;
import com.flchy.cloud.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 响应超时熔断处理器
 *
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public Mono<ResponseResult> fallback() {
        return Mono.just(new ResponseResult<>(BaseEWarning.SYSTEM_BUSY));
    }
}
