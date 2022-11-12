package com.jason.gateway.domain.mapstruct;

import com.jason.gateway.domain.dto.IgnoreUrlDto;
import com.jason.gateway.domain.po.IgnoreUrlPo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T14:58:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class GatewayMapperStructImpl implements GatewayMapperStruct {

    @Override
    public IgnoreUrlDto ignoreUriPo2IgnoreUriDto(IgnoreUrlPo ignoreUriPo) {
        if ( ignoreUriPo == null ) {
            return null;
        }

        IgnoreUrlDto ignoreUrlDto = new IgnoreUrlDto();

        ignoreUrlDto.setId( ignoreUriPo.getId() );
        ignoreUrlDto.setUrl( ignoreUriPo.getUrl() );

        return ignoreUrlDto;
    }

    @Override
    public List<IgnoreUrlDto> ignoreUriPoList2IgnoreUriDtoList(List<IgnoreUrlPo> ignoreUriPos) {
        if ( ignoreUriPos == null ) {
            return null;
        }

        List<IgnoreUrlDto> list = new ArrayList<IgnoreUrlDto>( ignoreUriPos.size() );
        for ( IgnoreUrlPo ignoreUrlPo : ignoreUriPos ) {
            list.add( ignoreUriPo2IgnoreUriDto( ignoreUrlPo ) );
        }

        return list;
    }
}
