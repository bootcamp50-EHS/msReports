package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Report01Service {

    private final WebClientCustomer clientService;
    private final WebClientProduct productService;
    private final WebClientAccount accountService;
    private final WebClientCredit creditService;


    public Mono<CustomerDTO> getReportAccountByCustomer(String clienteId) {
        return clientService.findCustomerById(clienteId)
                .flatMap(customerInfoDTO -> {
                    if ("Personal".equals(customerInfoDTO.getTypeCustomer())){
                        return Mono.just(new CustomerPersonDTO(customerInfoDTO));
                    }else if ("Empresarial".equals(customerInfoDTO.getTypeCustomer())) {
                        return Mono.just(new CustomerBusinessDTO(customerInfoDTO));
                    }else{
                        return Mono.error(new IllegalArgumentException("Tipo de cliente desconocido: " + customerInfoDTO.getTypeCustomer()));
                    }
                })
                .flatMap(cliente -> accountService.findAccountsByCustomer(clienteId)
                        .flatMap(cuenta -> productService.findProductById(cuenta.getProductId())
                                .map(producto -> {
                                    DetailAccountDTO detailAccount = new DetailAccountDTO();
                                    detailAccount.setProductName(producto.getNameAccount());
                                    detailAccount.setAccountNumber(cuenta.getAccountNumber());
                                    detailAccount.setAmount(cuenta.getAmount());
                                    //cuenta.setProducto(producto);
                                    return detailAccount;
                                }))
                        .collectList()
                        .doOnNext(cliente::setAccountList)
                        .thenReturn(cliente))
                .flatMap(cliente -> creditService.findCreditsByCustomer(clienteId)
                        .map(credito -> {
                            DetailCreditDTO detailCredit = new DetailCreditDTO();
                            detailCredit.setProductName(credito.getCreditType());
                            detailCredit.setAmount(credito.getAmount());
                            return detailCredit;
                        })
                        .collectList()
                        .doOnNext(cliente::setCreditList)
                        .thenReturn(cliente)

                )
                .onErrorResume(IllegalArgumentException.class, ex -> Mono.empty());
    }
}
