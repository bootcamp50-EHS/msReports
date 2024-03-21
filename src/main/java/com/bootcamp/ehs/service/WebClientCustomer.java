package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.CustomerDTO;
import com.bootcamp.ehs.DTO.CustomerInfoDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientCustomer {

    @Qualifier("customerWebClient")
    private final WebClient customerWebClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientCustomer.class);

    @Qualifier("gatewayServiceUrl")
    private final WebClient webClient;

    public Mono<CustomerInfoDTO> findCustomerById(String id) {
        LOGGER.info("En findCustomerById: el id= "+ id);
        return webClient.get()
                .uri("/api/customer/list/{id}", id)
                .retrieve()
                .bodyToMono(CustomerInfoDTO.class);
    }



}
