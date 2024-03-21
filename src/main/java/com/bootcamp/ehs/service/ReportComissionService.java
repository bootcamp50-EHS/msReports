package com.bootcamp.ehs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportComissionService {

    private final WebClientCustomer customerService;
    private final WebClientAccount accountService;
    private final WebClientTransaction transactionService;



}
