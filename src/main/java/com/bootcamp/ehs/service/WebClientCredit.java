package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.AccountDTO;
import com.bootcamp.ehs.DTO.CreditDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class WebClientCredit {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientCustomer.class);

    @Qualifier("gatewayServiceUrl")
    private final WebClient webClient;

    public Flux<CreditDTO> findCreditsByCustomer(String customerId){
        LOGGER.info("En findCreditByCustomerId: el id= "+ customerId);
        return webClient.get()
                .uri("/api/credit/retrieve/bycustomer/{customerId}", customerId)
                .retrieve()
                .bodyToFlux(CreditDTO.class);

    }
}
