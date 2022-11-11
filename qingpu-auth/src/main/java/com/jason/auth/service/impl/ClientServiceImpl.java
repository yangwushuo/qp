package com.jason.auth.service.impl;

import com.jason.auth.constant.MessageConstant;
import com.jason.auth.dao.ClientMapper;
import com.jason.auth.domain.dto.ClientDto;
import com.jason.auth.domain.mapstruct.ClientMapperStruct;
import com.jason.auth.service.ClientService;
import com.jason.auth.service.principal.ClientPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 客户端管理业务类
 *
 * @author Honghui [wanghonghui_work@163.com] 2021/3/18
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientMapper clientMapper;
  private final ClientMapperStruct clientMapperStruct;

  @PostConstruct
  public void initData() {
//    String clientSecret = passwordEncoder.encode("jason");
//    clientList = new ArrayList<>();
//    // 1、密码模式
//    clientList.add(Client.builder()
//        .clientId("client-app")
//        .resourceIds("oauth2-resource")
//        .secretRequire(false)
//        .clientSecret(clientSecret)
//        .scopeRequire(false)
//        .scope("all")
//        .authorizedGrantTypes("password,refresh_token")
//        .authorities("ADMIN,USER")
//        .accessTokenValidity(604800)
//        .refreshTokenValidity(2592000).build());
//    // 2、授权码模式
//    clientList.add(Client.builder()
//        .clientId("client-app-2")
//        .resourceIds("oauth2-resource2")
//        .secretRequire(false)
//        .clientSecret(clientSecret)
//        .scopeRequire(false)
//        .scope("all")
//        .authorizedGrantTypes("authorization_code,refresh_token")
//        .webServerRedirectUri("https://www.gathub.cn,https://www.baidu.com")
//        .authorities("USER")
//        .accessTokenValidity(3600)
//        .refreshTokenValidity(86400).build());
  }

  @Override
  public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

    ClientDto clientDto = clientMapperStruct.clientPo2ClientDto(clientMapper.getClientById(clientId));

    if (clientDto == null) {
      throw new ClientRegistrationException(MessageConstant.NOT_FOUND_CLIENT);
    }
    return new ClientPrincipal(clientDto);
  }
}
