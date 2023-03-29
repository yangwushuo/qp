package com.jason.binance.provider.mapstruct;

import com.jason.binance.api.request.BinanceParamRequest;
import com.jason.binance.biz.bo.BinanceKeyBo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T15:33:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class RequestMapStructImpl implements RequestMapStruct {

    @Override
    public BinanceKeyBo binanceKeyRequestRequest2Bo(BinanceParamRequest binanceParamRequest) {
        if ( binanceParamRequest == null ) {
            return null;
        }

        BinanceKeyBo binanceKeyBo = new BinanceKeyBo();

        binanceKeyBo.setApiKey( binanceParamRequest.getApiKey() );
        binanceKeyBo.setSecretKey( binanceParamRequest.getSecretKey() );

        return binanceKeyBo;
    }
}
