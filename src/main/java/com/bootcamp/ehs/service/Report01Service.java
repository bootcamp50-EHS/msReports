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
                .flatMap(this::createCustomerDTO)
                .flatMap(this::addAccountDetailsToCustomer)
                .flatMap(this::addCreditDetailsToCustomer)
                .onErrorResume(IllegalArgumentException.class, ex -> Mono.empty());
    }

    private Mono<CustomerDTO> createCustomerDTO(CustomerInfoDTO customerInfoDTO) {
        switch (customerInfoDTO.getTypeCustomer()) {
            case "Personal":
                return Mono.just(new CustomerPersonDTO(customerInfoDTO));
            case "Empresarial":
                return Mono.just(new CustomerBusinessDTO(customerInfoDTO));
            default:
                return Mono.error(new IllegalArgumentException("Tipo de cliente desconocido: " + customerInfoDTO.getTypeCustomer()));
        }
    }

    private Mono<CustomerDTO> addAccountDetailsToCustomer(CustomerDTO cliente) {
        return accountService.findAccountsByCustomer(cliente.getId())
                .flatMap(this::createDetailAccountDTO)
                .collectList()
                .doOnNext(cliente::setAccountList)
                .thenReturn(cliente);
    }

    private Mono<DetailAccountDTO> createDetailAccountDTO(AccountDTO cuenta) {
        return productService.findProductById(cuenta.getProductId())
                .map(producto -> {
                    DetailAccountDTO detailAccount = new DetailAccountDTO();
                    detailAccount.setProductName(producto.getNameAccount());
                    detailAccount.setAccountNumber(cuenta.getAccountNumber());
                    detailAccount.setAmount(cuenta.getAmount());
                    return detailAccount;
                });
    }

    private Mono<CustomerDTO> addCreditDetailsToCustomer(CustomerDTO cliente) {
        return creditService.findCreditsByCustomer(cliente.getId())
                .map(this::createDetailCreditDTO)
                .collectList()
                .doOnNext(cliente::setCreditList)
                .thenReturn(cliente);
    }

    private DetailCreditDTO createDetailCreditDTO(CreditDTO credito) {
        DetailCreditDTO detailCredit = new DetailCreditDTO();
        detailCredit.setProductName(credito.getCreditType());
        detailCredit.setAmount(credito.getAmount());
        return detailCredit;
    }


    /*
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
    }*/
}
