package com.jason.exchange.provider.mapstruct;

import com.jason.exchange.api.request.QuarterRequest;
import com.jason.exchange.biz.bo.QuarterBo;
import com.jason.exchange.biz.bo.QuarterBo.QuarterBoBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T22:33:22+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class RequestMapStructImpl implements RequestMapStruct {

    @Override
    public QuarterBo quarterRequest2Bo(QuarterRequest quarterRequest) {
        if ( quarterRequest == null ) {
            return null;
        }

        QuarterBoBuilder quarterBo = QuarterBo.builder();

        quarterBo.year( quarterRequest.getYear() );
        quarterBo.quarter( quarterRequest.getQuarter() );
        quarterBo.details( quarterRequest.getDetails() );

        return quarterBo.build();
    }
}
