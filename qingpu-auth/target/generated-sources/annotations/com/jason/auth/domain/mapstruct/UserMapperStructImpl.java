package com.jason.auth.domain.mapstruct;

import com.jason.auth.domain.dto.RoleDto;
import com.jason.auth.domain.dto.UserDto;
import com.jason.auth.domain.po.RolePo;
import com.jason.auth.domain.po.UserPo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T15:00:39+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class UserMapperStructImpl implements UserMapperStruct {

    @Override
    public UserDto userPo2UserDto(UserPo userPo) {
        if ( userPo == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setRoleDtos( rolePoList2RoleDtoList( userPo.getRolePos() ) );
        userDto.setId( userPo.getId() );
        userDto.setUsername( userPo.getUsername() );
        userDto.setEmail( userPo.getEmail() );
        userDto.setPassword( userPo.getPassword() );
        userDto.setPhone( userPo.getPhone() );
        userDto.setEnabled( userPo.getEnabled() );
        userDto.setAccountExpired( userPo.getAccountExpired() );
        userDto.setAccountLocked( userPo.getAccountLocked() );
        userDto.setCredentialsExpired( userPo.getCredentialsExpired() );

        return userDto;
    }

    @Override
    public RoleDto rolePo2RoleDto(RolePo rolePo) {
        if ( rolePo == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( rolePo.getId() );
        roleDto.setName( rolePo.getName() );
        roleDto.setNameZH( rolePo.getNameZH() );

        return roleDto;
    }

    @Override
    public List<RoleDto> rolePoList2RoleDtoList(List<RolePo> rolePos) {
        if ( rolePos == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( rolePos.size() );
        for ( RolePo rolePo : rolePos ) {
            list.add( rolePo2RoleDto( rolePo ) );
        }

        return list;
    }
}
