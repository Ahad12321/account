package com.lesson.account.service;

import com.lesson.account.dto.CustomerDto;
import com.lesson.account.dto.CustomerDtoConvertor;
import com.lesson.account.exception.CustomerNotFoundException;
import com.lesson.account.model.Customer;
import com.lesson.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDtoConvertor customerDtoConvertor;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerDtoConvertor customerDtoConvertor, CustomerRepository customerRepository) {
        this.customerDtoConvertor = customerDtoConvertor;
        this.customerRepository = customerRepository;
    }
    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not find by id: "+id));
    }

    public CustomerDto getCustomerById(String customerId) {

        return customerDtoConvertor.convertToCustomerDto(findCustomerById(customerId));

    }
}






















