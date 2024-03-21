package com.bootcamp.ehs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageDailyBalanceDTO {

    private String customerId;
    private List<Double> dailyAveragesBankAccounts;
    private List<Double> dailyAveragesBankCredits;
}
