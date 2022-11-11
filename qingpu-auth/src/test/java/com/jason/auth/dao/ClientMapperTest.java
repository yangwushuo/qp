package com.jason.auth.dao;

import com.jason.auth.domain.dto.ClientDto;
import com.jason.auth.domain.mapstruct.ClientMapperStruct;
import com.jason.auth.domain.po.ClientPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author：yangwushuo
 * @time：2022/10/29 21:44
 */
@SpringBootTest
class ClientMapperTest {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientMapperStruct clientMapperStruct;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void getClientById() {

        ClientPo clientPo = clientMapper.getClientById("web-app");
        ClientDto clientDto = clientMapperStruct.clientPo2ClientDto(clientPo);
        System.out.println(clientDto);

    }

    @Test
    void getPasswordEncoder(){
        String e = passwordEncoder.encode("jason");
        System.out.println(e);
    }
}