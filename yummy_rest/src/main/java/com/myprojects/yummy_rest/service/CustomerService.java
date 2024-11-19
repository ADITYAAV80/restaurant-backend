package com.myprojects.yummy_rest.service;

import com.myprojects.yummy_rest.dto.CustomerRequest;
import com.myprojects.yummy_rest.entity.Customer;
import com.myprojects.yummy_rest.mapper.CustomerMapper;
import com.myprojects.yummy_rest.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        repo.save(customer);
        return "Customer created";
    }
}