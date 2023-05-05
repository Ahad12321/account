package com.lesson.account.dto;

import com.lesson.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConvertor {
    private final CustomerAccountDtoConverter converter;

    public CustomerDtoConvertor(CustomerAccountDtoConverter converter) {
        this.converter = converter;
    }

    public AccountCostumerDto convertToAccountCustomer(Customer from){
        if (from==null){
            return new AccountCostumerDto("","","");
        }

        return new AccountCostumerDto(from.getId(), from.getName(), from.getSurname());
    }
    public CustomerDto convertToCustomerDto(Customer from){
        return new CustomerDto(from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(converter::convert).collect(Collectors.toSet()));
    }
}























