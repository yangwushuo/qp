package com.jason.user.provider.mapstruct;

import com.jason.user.biz.bo.AddAccountBo;
import com.jason.user.biz.bo.AddAccountBo.AddAccountBoBuilder;
import com.jason.user.biz.bo.FollowBo;
import com.jason.user.biz.bo.RoleBo;
import com.jason.user.biz.bo.UpUserInfoBo;
import com.jason.user.biz.bo.UpUserInfoBo.UpUserInfoBoBuilder;
import com.jason.user.biz.bo.UserInfoBo;
import com.qingpu.user.api.request.AddAccountRequest;
import com.qingpu.user.api.request.UpUserInfoRequest;
import com.qingpu.user.api.response.FollowResponse;
import com.qingpu.user.api.response.FollowResponse.FollowResponseBuilder;
import com.qingpu.user.api.response.RoleResponse;
import com.qingpu.user.api.response.RoleResponse.RoleResponseBuilder;
import com.qingpu.user.api.response.UserInfoResponse;
import com.qingpu.user.api.response.UserInfoResponse.UserInfoResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-18T16:19:38+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ResponseMapStructImpl implements ResponseMapStruct {

    @Override
    public UserInfoResponse userInfoBo2UserInfoResponse(UserInfoBo userInfoBo) {
        if ( userInfoBo == null ) {
            return null;
        }

        UserInfoResponseBuilder userInfoResponse = UserInfoResponse.builder();

        userInfoResponse.id( userInfoBo.getId() );
        userInfoResponse.username( userInfoBo.getUsername() );
        userInfoResponse.email( userInfoBo.getEmail() );
        userInfoResponse.phone( userInfoBo.getPhone() );
        userInfoResponse.enabled( userInfoBo.getEnabled() );
        userInfoResponse.accountExpired( userInfoBo.getAccountExpired() );
        userInfoResponse.accountLocked( userInfoBo.getAccountLocked() );
        userInfoResponse.credentialsExpired( userInfoBo.getCredentialsExpired() );
        userInfoResponse.portraitImage( userInfoBo.getPortraitImage() );
        userInfoResponse.introduction( userInfoBo.getIntroduction() );
        userInfoResponse.sex( userInfoBo.getSex() );
        userInfoResponse.createTime( userInfoBo.getCreateTime() );
        userInfoResponse.recentlyTime( userInfoBo.getRecentlyTime() );
        userInfoResponse.province( userInfoBo.getProvince() );
        userInfoResponse.birth( userInfoBo.getBirth() );
        userInfoResponse.roles( roleBoList2RoleResponseList( userInfoBo.getRoles() ) );

        return userInfoResponse.build();
    }

    @Override
    public RoleResponse roleBo2RoleResponse(RoleBo roleBo) {
        if ( roleBo == null ) {
            return null;
        }

        RoleResponseBuilder roleResponse = RoleResponse.builder();

        roleResponse.name( roleBo.getName() );
        roleResponse.nameZH( roleBo.getNameZH() );

        return roleResponse.build();
    }

    @Override
    public List<RoleResponse> roleBoList2RoleResponseList(List<RoleBo> roleBos) {
        if ( roleBos == null ) {
            return null;
        }

        List<RoleResponse> list = new ArrayList<RoleResponse>( roleBos.size() );
        for ( RoleBo roleBo : roleBos ) {
            list.add( roleBo2RoleResponse( roleBo ) );
        }

        return list;
    }

    @Override
    public UpUserInfoBo upUserInfoRequest2UpUserInfoBo(UpUserInfoRequest upUserInfoRequest) {
        if ( upUserInfoRequest == null ) {
            return null;
        }

        UpUserInfoBoBuilder upUserInfoBo = UpUserInfoBo.builder();

        upUserInfoBo.username( upUserInfoRequest.getUsername() );
        upUserInfoBo.sex( upUserInfoRequest.getSex() );
        upUserInfoBo.introduction( upUserInfoRequest.getIntroduction() );
        upUserInfoBo.province( upUserInfoRequest.getProvince() );
        upUserInfoBo.birth( upUserInfoRequest.getBirth() );

        return upUserInfoBo.build();
    }

    @Override
    public AddAccountBo addAccountRequest2AddAccountBo(AddAccountRequest addAccountRequest) {
        if ( addAccountRequest == null ) {
            return null;
        }

        AddAccountBoBuilder addAccountBo = AddAccountBo.builder();

        addAccountBo.symbol( addAccountRequest.getSymbol() );
        addAccountBo.content( addAccountRequest.getContent() );
        addAccountBo.password( addAccountRequest.getPassword() );
        addAccountBo.captcha( addAccountRequest.getCaptcha() );
        addAccountBo.timestamp( addAccountRequest.getTimestamp() );

        return addAccountBo.build();
    }

    @Override
    public FollowResponse followBo2FollowResponse(FollowBo followBo) {
        if ( followBo == null ) {
            return null;
        }

        FollowResponseBuilder followResponse = FollowResponse.builder();

        followResponse.id( followBo.getId() );
        followResponse.followUserId( followBo.getFollowUserId() );
        followResponse.username( followBo.getUsername() );
        followResponse.introduction( followBo.getIntroduction() );
        followResponse.portraitImage( followBo.getPortraitImage() );
        followResponse.followTime( followBo.getFollowTime() );

        return followResponse.build();
    }

    @Override
    public List<FollowResponse> followBoList2FollowResponseList(List<FollowBo> followBos) {
        if ( followBos == null ) {
            return null;
        }

        List<FollowResponse> list = new ArrayList<FollowResponse>( followBos.size() );
        for ( FollowBo followBo : followBos ) {
            list.add( followBo2FollowResponse( followBo ) );
        }

        return list;
    }
}
