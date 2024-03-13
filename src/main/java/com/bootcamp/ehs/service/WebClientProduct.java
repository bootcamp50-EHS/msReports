package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.CustomerDTO;
import com.bootcamp.ehs.DTO.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientProduct {

    @Qualifier("productWebClient")
    private final WebClient productWebClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientCustomer.class);

    public Mono<ProductDTO> findProductById(String id) {
        LOGGER.info("En findProductById: el id= "+ id);
        return productWebClient.get()
                .uri("/api/product/list/{id}", id)
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
}
