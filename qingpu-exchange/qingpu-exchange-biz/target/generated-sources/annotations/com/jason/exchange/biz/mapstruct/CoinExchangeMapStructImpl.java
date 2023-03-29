package com.jason.exchange.biz.mapstruct;

import com.jason.exchange.biz.bo.AddCoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountPerBo;
import com.jason.exchange.biz.bo.CoinExchangeBo;
import com.jason.exchange.biz.bo.UpCoinExchangeAccountBo;
import com.jason.exchange.biz.po.AddCoinExchangeAccountPo;
import com.jason.exchange.biz.po.CoinExchangeAccountPerPo;
import com.jason.exchange.biz.po.CoinExchangeAccountPo;
import com.jason.exchange.biz.po.CoinExchangePo;
import com.jason.exchange.biz.po.UpCoinExchangeAccountPo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T09:27:49+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class CoinExchangeMapStructImpl implements CoinExchangeMapStruct {

    @Override
    public CoinExchangeBo coinExchangePo2Bo(CoinExchangePo coinExchangePo) {
        if ( coinExchangePo == null ) {
            return null;
        }

        CoinExchangeBo coinExchangeBo = new CoinExchangeBo();

        coinExchangeBo.setId( coinExchangePo.getId() );
        coinExchangeBo.setName( coinExchangePo.getName() );
        coinExchangeBo.setSpot( coinExchangePo.getSpot() );
        coinExchangeBo.setUsdFuture( coinExchangePo.getUsdFuture() );
        coinExchangeBo.setCoinFuture( coinExchangePo.getCoinFuture() );
        coinExchangeBo.setOption( coinExchangePo.getOption() );

        return coinExchangeBo;
    }

    @Override
    public List<CoinExchangeBo> coinExchangePoList2BoList(List<CoinExchangePo> coinExchangePoList) {
        if ( coinExchangePoList == null ) {
            return null;
        }

        List<CoinExchangeBo> list = new ArrayList<CoinExchangeBo>( coinExchangePoList.size() );
        for ( CoinExchangePo coinExchangePo : coinExchangePoList ) {
            list.add( coinExchangePo2Bo( coinExchangePo ) );
        }

        return list;
    }

    @Override
    public CoinExchangeAccountBo coinExchangeAccountPo2Bo(CoinExchangeAccountPo coinExchangeAccountPo) {
        if ( coinExchangeAccountPo == null ) {
            return null;
        }

        CoinExchangeAccountBo coinExchangeAccountBo = new CoinExchangeAccountBo();

        coinExchangeAccountBo.setCoinExchangeBo( coinExchangePo2Bo( coinExchangeAccountPo.getCoinExchangePo() ) );
        coinExchangeAccountBo.setCoinExchangeAccountPerBo( coinExchangeAccountPerPo2Bo( coinExchangeAccountPo.getCoinExchangeAccountPerPo() ) );
        coinExchangeAccountBo.setId( coinExchangeAccountPo.getId() );
        coinExchangeAccountBo.setUserId( coinExchangeAccountPo.getUserId() );
        coinExchangeAccountBo.setCreateTime( coinExchangeAccountPo.getCreateTime() );
        coinExchangeAccountBo.setApiKey( coinExchangeAccountPo.getApiKey() );
        coinExchangeAccountBo.setSecretKey( coinExchangeAccountPo.getSecretKey() );
        coinExchangeAccountBo.setApiPassword( coinExchangeAccountPo.getApiPassword() );
        coinExchangeAccountBo.setUsageAccount( coinExchangeAccountPo.getUsageAccount() );
        coinExchangeAccountBo.setLatestUseTime( coinExchangeAccountPo.getLatestUseTime() );
        coinExchangeAccountBo.setNickName( coinExchangeAccountPo.getNickName() );

        return coinExchangeAccountBo;
    }

    @Override
    public List<CoinExchangeAccountBo> coinExchangeAccountPoList2BoList(List<CoinExchangeAccountPo> coinExchangeAccountPoList) {
        if ( coinExchangeAccountPoList == null ) {
            return null;
        }

        List<CoinExchangeAccountBo> list = new ArrayList<CoinExchangeAccountBo>( coinExchangeAccountPoList.size() );
        for ( CoinExchangeAccountPo coinExchangeAccountPo : coinExchangeAccountPoList ) {
            list.add( coinExchangeAccountPo2Bo( coinExchangeAccountPo ) );
        }

        return list;
    }

    @Override
    public CoinExchangeAccountPerBo coinExchangeAccountPerPo2Bo(CoinExchangeAccountPerPo coinExchangeAccountPerPo) {
        if ( coinExchangeAccountPerPo == null ) {
            return null;
        }

        CoinExchangeAccountPerBo coinExchangeAccountPerBo = new CoinExchangeAccountPerBo();

        coinExchangeAccountPerBo.setExchangeAccountId( coinExchangeAccountPerPo.getExchangeAccountId() );
        coinExchangeAccountPerBo.setVerCodeFollow( coinExchangeAccountPerPo.getVerCodeFollow() );
        coinExchangeAccountPerBo.setVerCode( coinExchangeAccountPerPo.getVerCode() );
        coinExchangeAccountPerBo.setOnline( coinExchangeAccountPerPo.getOnline() );
        coinExchangeAccountPerBo.setMoneyShow( coinExchangeAccountPerPo.getMoneyShow() );
        coinExchangeAccountPerBo.setTradeHistroy( coinExchangeAccountPerPo.getTradeHistroy() );
        coinExchangeAccountPerBo.setOption( coinExchangeAccountPerPo.getOption() );

        return coinExchangeAccountPerBo;
    }

    @Override
    public UpCoinExchangeAccountPo upCoinExchangeAccountBo2Po(UpCoinExchangeAccountBo upCoinExchangeAccountBo) {
        if ( upCoinExchangeAccountBo == null ) {
            return null;
        }

        UpCoinExchangeAccountPo upCoinExchangeAccountPo = new UpCoinExchangeAccountPo();

        upCoinExchangeAccountPo.setExchangeAccountId( upCoinExchangeAccountBo.getExchangeAccountId() );
        upCoinExchangeAccountPo.setNickName( upCoinExchangeAccountBo.getNickName() );
        upCoinExchangeAccountPo.setVerCodeFollow( upCoinExchangeAccountBo.getVerCodeFollow() );
        upCoinExchangeAccountPo.setVerCode( upCoinExchangeAccountBo.getVerCode() );
        upCoinExchangeAccountPo.setOnline( upCoinExchangeAccountBo.getOnline() );
        upCoinExchangeAccountPo.setMoneyShow( upCoinExchangeAccountBo.getMoneyShow() );
        upCoinExchangeAccountPo.setTradeHistory( upCoinExchangeAccountBo.getTradeHistory() );
        upCoinExchangeAccountPo.setOption( upCoinExchangeAccountBo.getOption() );

        return upCoinExchangeAccountPo;
    }

    @Override
    public AddCoinExchangeAccountPo addCoinExchangeAccountBo2Po(AddCoinExchangeAccountBo addCoinExchangeAccountBo) {
        if ( addCoinExchangeAccountBo == null ) {
            return null;
        }

        AddCoinExchangeAccountPo addCoinExchangeAccountPo = new AddCoinExchangeAccountPo();

        addCoinExchangeAccountPo.setNickName( addCoinExchangeAccountBo.getNickName() );
        addCoinExchangeAccountPo.setExchangeId( addCoinExchangeAccountBo.getExchangeId() );
        addCoinExchangeAccountPo.setApiKey( addCoinExchangeAccountBo.getApiKey() );
        addCoinExchangeAccountPo.setSecretKey( addCoinExchangeAccountBo.getSecretKey() );
        addCoinExchangeAccountPo.setApiPassword( addCoinExchangeAccountBo.getApiPassword() );
        addCoinExchangeAccountPo.setVerCodeFollow( addCoinExchangeAccountBo.getVerCodeFollow() );
        addCoinExchangeAccountPo.setVerCode( addCoinExchangeAccountBo.getVerCode() );
        addCoinExchangeAccountPo.setOnline( addCoinExchangeAccountBo.getOnline() );
        addCoinExchangeAccountPo.setMoneyShow( addCoinExchangeAccountBo.getMoneyShow() );
        addCoinExchangeAccountPo.setTradeHistory( addCoinExchangeAccountBo.getTradeHistory() );
        addCoinExchangeAccountPo.setOption( addCoinExchangeAccountBo.getOption() );

        return addCoinExchangeAccountPo;
    }
}
