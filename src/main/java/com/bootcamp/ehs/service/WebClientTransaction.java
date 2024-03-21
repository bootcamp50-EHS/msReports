package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.ProductDTO;
import com.bootcamp.ehs.DTO.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientTransaction {

    @Qualifier("transactionWebClient")
    private final WebClient transactionWebClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientCustomer.class);

    @Qualifier("gatewayServiceUrl")
    private final WebClient webClient;

    public Flux<TransactionDTO> findTransactionByAccountId(String accountId){
        LOGGER.info("WebClientTransaction : En findTransactionByAccountId : el id = "+ accountId);
        return webClient.get()
                .uri("/api/transaction/account/{accountId}", accountId)
                .retrieve()
                .bodyToFlux(TransactionDTO.class);
    }
}
