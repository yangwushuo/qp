package com.jason.user.biz.mapstruct;

import com.jason.user.biz.bo.AddAccountBo;
import com.jason.user.biz.bo.FollowBo;
import com.jason.user.biz.bo.RoleBo;
import com.jason.user.biz.bo.UpUserInfoBo;
import com.jason.user.biz.bo.UserInfoBo;
import com.jason.user.biz.po.AddAccountPo;
import com.jason.user.biz.po.FollowPo;
import com.jason.user.biz.po.RolePo;
import com.jason.user.biz.po.UpUserInfoPo;
import com.jason.user.biz.po.UserInfoPo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-10T14:59:47+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class UserMapStructImpl implements UserMapStruct {

    @Override
    public UserInfoBo userInfoPo2UserInfoBo(UserInfoPo userInfoPo) {
        if ( userInfoPo == null ) {
            return null;
        }

        UserInfoBo userInfoBo = new UserInfoBo();

        userInfoBo.setId( userInfoPo.getId() );
        userInfoBo.setUsername( userInfoPo.getUsername() );
        userInfoBo.setEmail( userInfoPo.getEmail() );
        userInfoBo.setEnabled( userInfoPo.getEnabled() );
        userInfoBo.setAccountExpired( userInfoPo.getAccountExpired() );
        userInfoBo.setAccountLocked( userInfoPo.getAccountLocked() );
        userInfoBo.setCredentialsExpired( userInfoPo.getCredentialsExpired() );
        userInfoBo.setPortraitImage( userInfoPo.getPortraitImage() );
        userInfoBo.setIntroduction( userInfoPo.getIntroduction() );
        userInfoBo.setSex( userInfoPo.getSex() );
        userInfoBo.setCreateTime( userInfoPo.getCreateTime() );
        userInfoBo.setRecentlyTime( userInfoPo.getRecentlyTime() );
        userInfoBo.setProvince( userInfoPo.getProvince() );
        userInfoBo.setBirth( userInfoPo.getBirth() );
        userInfoBo.setRoles( rolePoListToRoleBoList( userInfoPo.getRoles() ) );

        return userInfoBo;
    }

    @Override
    public UpUserInfoPo upUserInfoBo2UpUserInfoPo(UpUserInfoBo upUserInfoBo) {
        if ( upUserInfoBo == null ) {
            return null;
        }

        UpUserInfoPo upUserInfoPo = new UpUserInfoPo();

        upUserInfoPo.setUsername( upUserInfoBo.getUsername() );
        upUserInfoPo.setEmail( upUserInfoBo.getEmail() );
        upUserInfoPo.setPortraitImage( upUserInfoBo.getPortraitImage() );
        upUserInfoPo.setSex( upUserInfoBo.getSex() );
        upUserInfoPo.setIntroduction( upUserInfoBo.getIntroduction() );
        upUserInfoPo.setProvince( upUserInfoBo.getProvince() );
        upUserInfoPo.setBirth( upUserInfoBo.getBirth() );

        return upUserInfoPo;
    }

    @Override
    public AddAccountPo addAccountBo2AddAccountPo(AddAccountBo addAccountBo) {
        if ( addAccountBo == null ) {
            return null;
        }

        AddAccountPo addAccountPo = new AddAccountPo();

        addAccountPo.setSymbol( addAccountBo.getSymbol() );
        addAccountPo.setContent( addAccountBo.getContent() );
        addAccountPo.setPassword( addAccountBo.getPassword() );
        addAccountPo.setCaptcha( addAccountBo.getCaptcha() );
        addAccountPo.setTimestamp( addAccountBo.getTimestamp() );

        return addAccountPo;
    }

    @Override
    public FollowBo followPo2FollowBo(FollowPo followPo) {
        if ( followPo == null ) {
            return null;
        }

        FollowBo followBo = new FollowBo();

        followBo.setId( followPo.getId() );
        followBo.setFollowUserId( followPo.getFollowUserId() );
        followBo.setUsername( followPo.getUsername() );
        followBo.setIntroduction( followPo.getIntroduction() );
        followBo.setPortraitImage( followPo.getPortraitImage() );
        followBo.setFollowTime( followPo.getFollowTime() );

        return followBo;
    }

    @Override
    public List<FollowBo> followPoList2FollowBoList(List<FollowPo> followPos) {
        if ( followPos == null ) {
            return null;
        }

        List<FollowBo> list = new ArrayList<FollowBo>( followPos.size() );
        for ( FollowPo followPo : followPos ) {
            list.add( followPo2FollowBo( followPo ) );
        }

        return list;
    }

    protected RoleBo rolePoToRoleBo(RolePo rolePo) {
        if ( rolePo == null ) {
            return null;
        }

        RoleBo roleBo = new RoleBo();

        roleBo.setName( rolePo.getName() );
        roleBo.setNameZH( rolePo.getNameZH() );

        return roleBo;
    }

    protected List<RoleBo> rolePoListToRoleBoList(List<RolePo> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleBo> list1 = new ArrayList<RoleBo>( list.size() );
        for ( RolePo rolePo : list ) {
            list1.add( rolePoToRoleBo( rolePo ) );
        }

        return list1;
    }
}
