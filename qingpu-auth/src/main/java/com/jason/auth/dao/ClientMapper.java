package com.jason.auth.dao;

import com.jason.auth.domain.po.ClientPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author：yangwushuo
 * @time：2022/10/29 20:59
 */
@Mapper
public interface ClientMapper {

    ClientPo getClientById(@Param("clientId") String clientId);

}
