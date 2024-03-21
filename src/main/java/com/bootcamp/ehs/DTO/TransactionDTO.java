package com.bootcamp.ehs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private String id;
    // Codigo de la operacion
    private String codeOperation;
    //Descripcion de la transaccion
    private String description;
    // Fecha de la transaccion
    private String dateTransaction;
    //Monto de la transaccion
    private BigDecimal amount;
    //Tipo de Transaccion (Deposito o Retiro)
    private String typeTransaction;
    // Signo de la trnasaccion (1 o -1)
    private Integer sign;
    //Cuenta a la cual pertenece la transaccion
    private String accountId;
    // Fecha y hora de la transaccion
    private LocalDateTime dateTimeTransaction;

}
