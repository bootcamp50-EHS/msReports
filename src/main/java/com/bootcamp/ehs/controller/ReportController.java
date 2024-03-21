package com.bootcamp.ehs.controller;

import com.bootcamp.ehs.DTO.CustomerDTO;
import com.bootcamp.ehs.DTO.Report01DTO;
import com.bootcamp.ehs.service.Report01Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
public class ReportController {

    private final Report01Service report01Service;

    @GetMapping("/productsbycustomer/{customerId}")
    public Mono<CustomerDTO> getAccountsByCustomer(@PathVariable("customerId") String customerId){
        return report01Service.getReportAccountByCustomer(customerId);
    }
}
