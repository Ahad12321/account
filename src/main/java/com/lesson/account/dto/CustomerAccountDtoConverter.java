package com.lesson.account.dto;

import com.lesson.account.model.Account;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    private final TransactionDtoConvertor convertor;

    public CustomerAccountDtoConverter(TransactionDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public CustomerAccountDto convert(Account from){
        return new CustomerAccountDto(
                from.getId(),
                from.getBalance(),
                from.getTransaction().stream().map(convertor::convert).collect(Collectors.toSet()),
                from.getCreationDate()

        );
    }
}





















