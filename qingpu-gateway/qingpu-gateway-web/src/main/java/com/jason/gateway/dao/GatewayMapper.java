package com.jason.gateway.dao;

import com.jason.gateway.domain.po.IgnoreUrlPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/30 19:28
 */
@Mapper
public interface GatewayMapper {

    List<IgnoreUrlPo> getAllIgnoreUrls();

}
