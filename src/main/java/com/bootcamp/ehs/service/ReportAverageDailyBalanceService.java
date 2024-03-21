package com.bootcamp.ehs.service;

import com.bootcamp.ehs.DTO.AccountDTO;
import com.bootcamp.ehs.DTO.AverageDailyBalanceDTO;
import com.bootcamp.ehs.DTO.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportAverageDailyBalanceService {

    /*private final WebClientTransaction transactionService;
    private final WebClientAccount accountService;

    public Flux<AverageDailyBalanceDTO> getAverageDailyBalances(String customerId) {
        return Flux.concat(getAverageDailyBalancesForBankAccounts(), getAverageDailyBalancesForBankCredits());
    }

    private Flux<AverageDailyBalanceDTO> getAverageDailyBalancesForBankAccounts() {
        return accountService.findAll()
                .flatMap(this::calculateAverageDailyBalance);
    }

    private Flux<AverageDailyBalanceDTO> getAverageDailyBalancesForBankCredits() {
        return bankCreditRepo.findAll()
                .flatMap(this::calculateAverageDailyBalance);
    }

    private Mono<AverageDailyBalanceDTO> calculateAverageDailyBalance(AccountDTO account) {
        return transactionService.findTransactionByAccountId(account.getId())
                .groupBy(transaction -> transaction.getDateTimeTransaction().getDayOfMonth())
                .flatMap(grouped -> grouped.collectList()
                        .map(this::calculateAverage))
                .collectList()
                .map(dailyAverages -> new AverageDailyBalanceDTO(account.getId(), dailyAverages));
    }

    private Mono<AverageDailyBalanceDTO> calculateAverageDailyBalance(BankCredit bankCredit) {
        return transactionRepo.findByBankCreditId(bankCredit.getId())
                .groupBy(transaction -> transaction.getDate().getDayOfMonth())
                .flatMap(grouped -> grouped.collectList()
                        .map(this::calculateAverage))
                .collectList()
                .map(dailyAverages -> new AverageDailyBalance(bankCredit.getId(), dailyAverages));
    }

    private Double calculateAverage(List<Double> amounts) {
        return amounts.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    */
}
