package org.myprojects.yummy_rest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myprojects.yummy_rest.dto.CustomerRequest;
import org.myprojects.yummy_rest.dto.CustomerResponse;
import org.myprojects.yummy_rest.dto.CustomerUpdateRequest;
import org.myprojects.yummy_rest.helper.JWTHelper;
import org.myprojects.yummy_rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final JWTHelper jwtHelper;

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("email") String email, HttpServletRequest request) {
        if(!jwtHelper.validateAuthorizationHeader(request.getHeader("Authorization"))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(customerService.retrieveCustomer(email));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PatchMapping
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerUpdateRequest customerUpdateRequest, HttpServletRequest request) {
        if(!jwtHelper.validateAuthorizationHeader(request.getHeader("Authorization"))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(customerService.updateCustomer(customerUpdateRequest, request.getHeader("Authorization")));
    }
}