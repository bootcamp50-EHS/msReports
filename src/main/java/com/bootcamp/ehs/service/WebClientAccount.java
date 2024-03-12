package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.AccountDTO;
import com.bootcamp.ehs.DTO.ProductDTO;
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
public class WebClientAccount {

    @Qualifier("accountWebClient")
    private final WebClient accountWebClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientCustomer.class);

    public Mono<ProductDTO> findProductById(String id) {
        LOGGER.info("En findAccountById: el id= "+ id);
        return accountWebClient.get()
                .uri("/account/{id}", id)
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }

    public Flux<AccountDTO> findAccountsByCustomer(String customerId){
        LOGGER.info("En findAccountByCustomerId: el id= "+ customerId);
        return accountWebClient.get()
                .uri("/api/account/bycustomer/{customerId}", customerId)
                .retrieve()
                .bodyToFlux(AccountDTO.class);

    }

}
