package com.bootcamp.ehs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPersonDTO extends CustomerDTO {

    private String firstName;
    private String lastName;
    public CustomerPersonDTO(CustomerInfoDTO customerInfoDTO) {
        super(customerInfoDTO);
        this.firstName = customerInfoDTO.getFirstName();
        this.lastName = customerInfoDTO.getLastName();
    }
}
