package com.jason.user.provider.mapstruct;

import com.jason.user.biz.bo.UpPhoneAndEmailBo;
import com.jason.user.biz.bo.VerPwdBo;
import com.qingpu.user.api.request.UpPhoneAndEmailRequest;
import com.qingpu.user.api.request.VerPwdRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-18T16:19:39+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class RequestMapStructImpl implements RequestMapStruct {

    @Override
    public VerPwdBo verPwdRequest2VerPwdBo(VerPwdRequest verPwdRequest) {
        if ( verPwdRequest == null ) {
            return null;
        }

        VerPwdBo verPwdBo = new VerPwdBo();

        verPwdBo.setPassword( verPwdRequest.getPassword() );

        return verPwdBo;
    }

    @Override
    public UpPhoneAndEmailBo upPhoneAndEmailRequest2UpPhoneAndEmailBo(UpPhoneAndEmailRequest upPhoneAndEmailRequest) {
        if ( upPhoneAndEmailRequest == null ) {
            return null;
        }

        UpPhoneAndEmailBo upPhoneAndEmailBo = new UpPhoneAndEmailBo();

        upPhoneAndEmailBo.setPhone( upPhoneAndEmailRequest.getPhone() );
        upPhoneAndEmailBo.setEmail( upPhoneAndEmailRequest.getEmail() );
        upPhoneAndEmailBo.setCaptchaKey( upPhoneAndEmailRequest.getCaptchaKey() );
        upPhoneAndEmailBo.setCaptcha( upPhoneAndEmailRequest.getCaptcha() );

        return upPhoneAndEmailBo;
    }
}
