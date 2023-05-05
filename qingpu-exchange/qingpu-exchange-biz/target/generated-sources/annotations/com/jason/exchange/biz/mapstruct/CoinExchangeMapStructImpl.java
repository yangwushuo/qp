package com.jason.exchange.biz.mapstruct;

import com.jason.exchange.biz.bo.QuarterBo;
import com.jason.exchange.biz.po.QuarterPo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T22:33:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class CoinExchangeMapStructImpl implements CoinExchangeMapStruct {

    @Override
    public QuarterPo quarterBo2Po(QuarterBo quarterBo) {
        if ( quarterBo == null ) {
            return null;
        }

        QuarterPo quarterPo = new QuarterPo();

        quarterPo.setYear( quarterBo.getYear() );
        quarterPo.setQuarter( quarterBo.getQuarter() );
        quarterPo.setDetails( quarterBo.getDetails() );

        return quarterPo;
    }
}
