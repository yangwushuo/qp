package com.jason.auth.domain.mapstruct;

import com.jason.auth.domain.dto.ResourceDto;
import com.jason.auth.domain.po.ResourcePo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T12:52:27+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ResourceMapperStructImpl implements ResourceMapperStruct {

    @Autowired
    private UserMapperStruct userMapperStruct;

    @Override
    public ResourceDto resourcePo2ResourceDto(ResourcePo resourcePo) {
        if ( resourcePo == null ) {
            return null;
        }

        ResourceDto resourceDto = new ResourceDto();

        resourceDto.setRoleDtos( userMapperStruct.rolePoList2RoleDtoList( resourcePo.getRolePos() ) );
        resourceDto.setId( resourcePo.getId() );
        resourceDto.setRouteName( resourcePo.getRouteName() );

        return resourceDto;
    }

    @Override
    public List<ResourceDto> resourcePoList2ResourceDtoList(List<ResourcePo> resourcePos) {
        if ( resourcePos == null ) {
            return null;
        }

        List<ResourceDto> list = new ArrayList<ResourceDto>( resourcePos.size() );
        for ( ResourcePo resourcePo : resourcePos ) {
            list.add( resourcePo2ResourceDto( resourcePo ) );
        }

        return list;
    }
}
