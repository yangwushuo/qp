package com.jason.user.provider.mapstruct;

import com.jason.user.biz.bo.UpPhoneAndEmailBo;
import com.jason.user.biz.bo.VerPwdBo;
import com.qingpu.user.api.request.UpPhoneAndEmailRequest;
import com.qingpu.user.api.request.VerPwdRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：yangwushuo
 * @time：2022/11/14 23:09
 */
@Mapper(componentModel = "spring")
public interface RequestMapStruct {

    RequestMapStruct INSTANCE = Mappers.getMapper(RequestMapStruct.class);

    VerPwdBo verPwdRequest2VerPwdBo(VerPwdRequest verPwdRequest);

    UpPhoneAndEmailBo upPhoneAndEmailRequest2UpPhoneAndEmailBo(UpPhoneAndEmailRequest upPhoneAndEmailRequest);

}
