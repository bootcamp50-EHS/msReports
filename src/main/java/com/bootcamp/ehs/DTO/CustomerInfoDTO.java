package com.bootcamp.ehs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoDTO {
    private String id;
    private String docType;
    private String docNumber;
    private String typeCustomer;
    private String firstName;
    private String lastName;
    private String businessName;
    private List<DetailAccountDTO> accountList;
}
