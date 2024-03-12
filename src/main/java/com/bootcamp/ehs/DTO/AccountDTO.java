package com.bootcamp.ehs.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @Id
    private String id;
    private String customerId;
    private String productId;
    private String accountNumber;
    private String creationDate;
    private BigDecimal amount;

}
