package com.bootcamp.ehs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBusinessDTO extends CustomerDTO{

    private String businessName;

    public CustomerBusinessDTO(CustomerInfoDTO customerInfoDTO) {
        super(customerInfoDTO);
        this.businessName = customerInfoDTO.getBusinessName();

    }
}
