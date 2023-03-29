package com.jason.exchange.provider.mapstruct;

import com.jason.exchange.api.response.CoinExchangeAccountPerResponse;
import com.jason.exchange.api.response.CoinExchangeAccountResponse;
import com.jason.exchange.api.response.CoinExchangeResponse;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountPerBo;
import com.jason.exchange.biz.bo.CoinExchangeBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-26T22:42:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ResponseMapStructImpl implements ResponseMapStruct {

    @Override
    public CoinExchangeResponse exchangeBo2Response(CoinExchangeBo exchangeBo) {
        if ( exchangeBo == null ) {
            return null;
        }

        CoinExchangeResponse coinExchangeResponse = new CoinExchangeResponse();

        coinExchangeResponse.setId( exchangeBo.getId() );
        coinExchangeResponse.setName( exchangeBo.getName() );
        coinExchangeResponse.setSpot( exchangeBo.getSpot() );
        coinExchangeResponse.setUsdFuture( exchangeBo.getUsdFuture() );
        coinExchangeResponse.setCoinFuture( exchangeBo.getCoinFuture() );
        coinExchangeResponse.setOption( exchangeBo.getOption() );

        return coinExchangeResponse;
    }

    @Override
    public List<CoinExchangeResponse> exchangeBoList2ResponseList(List<CoinExchangeBo> exchangeBoList) {
        if ( exchangeBoList == null ) {
            return null;
        }

        List<CoinExchangeResponse> list = new ArrayList<CoinExchangeResponse>( exchangeBoList.size() );
        for ( CoinExchangeBo coinExchangeBo : exchangeBoList ) {
            list.add( exchangeBo2Response( coinExchangeBo ) );
        }

        return list;
    }

    @Override
    public CoinExchangeAccountResponse coinExchangeAccountBo2Response(CoinExchangeAccountBo coinExchangeAccountBo) {
        if ( coinExchangeAccountBo == null ) {
            return null;
        }

        CoinExchangeAccountResponse coinExchangeAccountResponse = new CoinExchangeAccountResponse();

        coinExchangeAccountResponse.setCoinExchangeResponse( exchangeBo2Response( coinExchangeAccountBo.getCoinExchangeBo() ) );
        coinExchangeAccountResponse.setCoinExchangeAccountPerResponse( coinExchangeAccountPerBo2Response( coinExchangeAccountBo.getCoinExchangeAccountPerBo() ) );
        coinExchangeAccountResponse.setId( coinExchangeAccountBo.getId() );
        coinExchangeAccountResponse.setUserId( coinExchangeAccountBo.getUserId() );
        coinExchangeAccountResponse.setCreateTime( coinExchangeAccountBo.getCreateTime() );
        coinExchangeAccountResponse.setUsageAccount( coinExchangeAccountBo.getUsageAccount() );
        coinExchangeAccountResponse.setLatestUseTime( coinExchangeAccountBo.getLatestUseTime() );
        coinExchangeAccountResponse.setNickName( coinExchangeAccountBo.getNickName() );

        return coinExchangeAccountResponse;
    }

    @Override
    public List<CoinExchangeAccountResponse> coinExchangeAccountBoList2ResponseList(List<CoinExchangeAccountBo> coinExchangeAccountBoList) {
        if ( coinExchangeAccountBoList == null ) {
            return null;
        }

        List<CoinExchangeAccountResponse> list = new ArrayList<CoinExchangeAccountResponse>( coinExchangeAccountBoList.size() );
        for ( CoinExchangeAccountBo coinExchangeAccountBo : coinExchangeAccountBoList ) {
            list.add( coinExchangeAccountBo2Response( coinExchangeAccountBo ) );
        }

        return list;
    }

    @Override
    public CoinExchangeAccountPerResponse coinExchangeAccountPerBo2Response(CoinExchangeAccountPerBo coinExchangeAccountPerBo) {
        if ( coinExchangeAccountPerBo == null ) {
            return null;
        }

        CoinExchangeAccountPerResponse coinExchangeAccountPerResponse = new CoinExchangeAccountPerResponse();

        coinExchangeAccountPerResponse.setExchangeAccountId( coinExchangeAccountPerBo.getExchangeAccountId() );
        coinExchangeAccountPerResponse.setVerCodeFollow( coinExchangeAccountPerBo.getVerCodeFollow() );
        coinExchangeAccountPerResponse.setVerCode( coinExchangeAccountPerBo.getVerCode() );
        coinExchangeAccountPerResponse.setOnline( coinExchangeAccountPerBo.getOnline() );
        coinExchangeAccountPerResponse.setMoneyShow( coinExchangeAccountPerBo.getMoneyShow() );
        coinExchangeAccountPerResponse.setTradeHistroy( coinExchangeAccountPerBo.getTradeHistroy() );
        coinExchangeAccountPerResponse.setOption( coinExchangeAccountPerBo.getOption() );

        return coinExchangeAccountPerResponse;
    }
}
