package com.jason.auth.domain.mapstruct;

import com.jason.auth.domain.dto.ClientDto;
import com.jason.auth.domain.po.ClientPo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T12:52:27+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ClientMapperStructImpl implements ClientMapperStruct {

    @Override
    public ClientDto clientPo2ClientDto(ClientPo clientPo) {
        if ( clientPo == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setClientId( clientPo.getClientId() );
        clientDto.setResourceIds( clientPo.getResourceIds() );
        clientDto.setClientSecret( clientPo.getClientSecret() );
        clientDto.setScope( clientPo.getScope() );
        clientDto.setAuthorizedGrantTypes( clientPo.getAuthorizedGrantTypes() );
        clientDto.setAuthorities( clientPo.getAuthorities() );
        clientDto.setWebServerRedirectUri( clientPo.getWebServerRedirectUri() );
        clientDto.setAccessTokenValidity( clientPo.getAccessTokenValidity() );
        clientDto.setRefreshTokenValidity( clientPo.getRefreshTokenValidity() );
        clientDto.setAdditionalInformation( clientPo.getAdditionalInformation() );
        clientDto.setAutoapprove( clientPo.getAutoapprove() );
        clientDto.setSecretRequire( clientPo.getSecretRequire() );
        clientDto.setScopeRequire( clientPo.getScopeRequire() );

        return clientDto;
    }
}
