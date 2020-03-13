package com.flchy.cloud.miniapp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flchy.cloud.miniapp.bean.WechatUserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 多微信小程序  微信公众号关联表 Mapper 接口
 * </p>
 *
 * @author nieqs
 * @since 2019-09-27
 */
public interface WechatUserExtendMapper extends BaseMapper<WechatUserExtend> {

    List<WechatUserExtend> queryWechatUserExtendByAppIdAndUnionId(@Param("appId") String appId, @Param("unionIds") List<String> unionIds);
}
