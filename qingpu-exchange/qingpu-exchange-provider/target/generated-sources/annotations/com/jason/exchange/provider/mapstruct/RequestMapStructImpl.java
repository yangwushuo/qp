package com.jason.exchange.provider.mapstruct;

import com.jason.exchange.api.request.AddCoinExchangeAccountRequest;
import com.jason.exchange.api.request.UpCoinExchangeAccountRequest;
import com.jason.exchange.biz.bo.AddCoinExchangeAccountBo;
import com.jason.exchange.biz.bo.UpCoinExchangeAccountBo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-26T22:42:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class RequestMapStructImpl implements RequestMapStruct {

    @Override
    public UpCoinExchangeAccountBo upCoinExchangeAccountRequest2Bo(UpCoinExchangeAccountRequest upCoinExchangeAccountRequest) {
        if ( upCoinExchangeAccountRequest == null ) {
            return null;
        }

        UpCoinExchangeAccountBo upCoinExchangeAccountBo = new UpCoinExchangeAccountBo();

        upCoinExchangeAccountBo.setExchangeAccountId( upCoinExchangeAccountRequest.getExchangeAccountId() );
        upCoinExchangeAccountBo.setNickName( upCoinExchangeAccountRequest.getNickName() );
        upCoinExchangeAccountBo.setVerCodeFollow( upCoinExchangeAccountRequest.getVerCodeFollow() );
        upCoinExchangeAccountBo.setVerCode( upCoinExchangeAccountRequest.getVerCode() );
        upCoinExchangeAccountBo.setOnline( upCoinExchangeAccountRequest.getOnline() );
        upCoinExchangeAccountBo.setMoneyShow( upCoinExchangeAccountRequest.getMoneyShow() );
        upCoinExchangeAccountBo.setTradeHistory( upCoinExchangeAccountRequest.getTradeHistory() );
        upCoinExchangeAccountBo.setOption( upCoinExchangeAccountRequest.getOption() );

        return upCoinExchangeAccountBo;
    }

    @Override
    public AddCoinExchangeAccountBo addCoinExchangeAccountRequest2Bo(AddCoinExchangeAccountRequest addCoinExchangeAccountRequest) {
        if ( addCoinExchangeAccountRequest == null ) {
            return null;
        }

        AddCoinExchangeAccountBo addCoinExchangeAccountBo = new AddCoinExchangeAccountBo();

        addCoinExchangeAccountBo.setNickName( addCoinExchangeAccountRequest.getNickName() );
        addCoinExchangeAccountBo.setExchangeId( addCoinExchangeAccountRequest.getExchangeId() );
        addCoinExchangeAccountBo.setApiKey( addCoinExchangeAccountRequest.getApiKey() );
        addCoinExchangeAccountBo.setSecretKey( addCoinExchangeAccountRequest.getSecretKey() );
        addCoinExchangeAccountBo.setApiPassword( addCoinExchangeAccountRequest.getApiPassword() );
        addCoinExchangeAccountBo.setVerCodeFollow( addCoinExchangeAccountRequest.getVerCodeFollow() );
        addCoinExchangeAccountBo.setVerCode( addCoinExchangeAccountRequest.getVerCode() );
        addCoinExchangeAccountBo.setOnline( addCoinExchangeAccountRequest.getOnline() );
        addCoinExchangeAccountBo.setMoneyShow( addCoinExchangeAccountRequest.getMoneyShow() );
        addCoinExchangeAccountBo.setTradeHistory( addCoinExchangeAccountRequest.getTradeHistory() );
        addCoinExchangeAccountBo.setOption( addCoinExchangeAccountRequest.getOption() );

        return addCoinExchangeAccountBo;
    }
}
