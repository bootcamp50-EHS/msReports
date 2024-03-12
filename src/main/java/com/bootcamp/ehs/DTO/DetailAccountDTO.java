package com.bootcamp.ehs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailAccountDTO {

    private String productName;
    private String accountNumber;
    private BigDecimal amount;

}
