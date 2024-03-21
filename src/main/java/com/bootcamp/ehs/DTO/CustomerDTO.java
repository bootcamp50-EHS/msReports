package com.bootcamp.ehs.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class CustomerDTO {

    private String id;
    private String docType;
    private String docNumber;
    private String typeCustomer;
    private List<DetailAccountDTO> accountList;
    private List<DetailCreditDTO> creditList;

    public CustomerDTO(CustomerInfoDTO customerInfoDTO){
        this.id = customerInfoDTO.getId();
        this.docType = customerInfoDTO.getDocType();
        this.docNumber = customerInfoDTO.getDocNumber();
        this.typeCustomer = customerInfoDTO.getTypeCustomer();
        this.accountList = customerInfoDTO.getAccountList();
    }

}
