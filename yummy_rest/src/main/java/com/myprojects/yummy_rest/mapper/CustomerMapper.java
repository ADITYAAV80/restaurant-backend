package com.myprojects.yummy_rest.mapper;

import com.myprojects.yummy_rest.dto.CustomerRequest;
import com.myprojects.yummy_rest.dto.CustomerResponse;
import com.myprojects.yummy_rest.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}