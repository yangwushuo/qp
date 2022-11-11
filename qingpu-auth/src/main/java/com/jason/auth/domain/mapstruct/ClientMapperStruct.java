package com.jason.auth.domain.mapstruct;

import com.jason.auth.domain.dto.ClientDto;
import com.jason.auth.domain.po.ClientPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：yangwushuo
 * @time：2022/10/29 21:47
 */
@Mapper(componentModel = "spring")
public interface ClientMapperStruct {

    ClientMapperStruct INSTANCE = Mappers.getMapper(ClientMapperStruct.class);

    ClientDto clientPo2ClientDto(ClientPo clientPo);

}
