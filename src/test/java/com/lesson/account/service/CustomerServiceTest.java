package com.lesson.account.service;

import com.lesson.account.dto.CustomerDto;
import com.lesson.account.dto.CustomerDtoConvertor;
import com.lesson.account.exception.CustomerNotFoundException;
import com.lesson.account.model.Customer;
import com.lesson.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {
    private CustomerService service;
    private  CustomerDtoConvertor customerDtoConvertor;
    private  CustomerRepository customerRepository;
    @BeforeEach
    public void setUp(){
         customerRepository= mock(CustomerRepository.class);
         customerDtoConvertor=mock(CustomerDtoConvertor.class);
         service=new CustomerService(customerDtoConvertor,customerRepository);
    }
    @Test
    public void  testFindByCustomerId_whenCustomerIdExsits_shouldReturnCustomer(){
        Customer customer=new Customer("id","name","surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Customer result =service.findCustomerById("id");
        assertEquals(result,customer);
    }
    @Test
    public void  testFindByCustomerId_whenCustomerIdDoesNotExsits_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
       assertThrows(CustomerNotFoundException.class,()->service.findCustomerById("id"));
    }

    @Test
    public void  testGetCustomerById_whenCustomerIdExsits_shouldReturnCustomer(){
        Customer customer=new Customer("id","name","surname", Set.of());
        CustomerDto customerDto=new CustomerDto("id","name","surname",Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(customerDtoConvertor.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result =service.getCustomerById("id");
        assertEquals(result,customerDto);
    }
    @Test
    public void  testGetByCustomerId_whenCustomerIdDoesNotExsits_shouldThrowCustomerNotFoundException(){
        Mockito.when( customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,
                ()->service.getCustomerById("id"));
        Mockito.verifyNoInteractions(customerDtoConvertor);
    }

}