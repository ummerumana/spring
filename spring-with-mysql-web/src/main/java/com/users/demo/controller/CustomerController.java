package com.users.demo.controller;

import com.users.demo.entities.Customer;
import com.users.demo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@Tag(name = "customer", description = "the Customers API")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Operation(summary = "Find all customers", description = "returns All customers details", tags = { "customer" })
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Find customer by ID", description = "Returns a single customer details", tags = { "customer" })
    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    Customer getCustomerById(@PathVariable("id") int id)
    {
        return customerService.getCustomerById(id);
    }

    @Operation(summary = "Delate customer by ID", description = "deletes a single customer", tags = { "customer" })
    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{id}" )
    void deleteCustomerById(@PathVariable("id") int id)
    {
        customerService.deleteCustomerById(id);
    }

    @Operation(summary = "Updates customer by ID", description = "Updates a single customer", tags = { "customer" })
    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer)
    {
        customerService.updateCustomerById(id, customer);
    }

    @Operation(summary = "Add a new customer", description = "", tags = { "customer" })
    @RequestMapping(method = RequestMethod.POST,value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void insertCustomer(@RequestBody Customer customer){
        customerService.insertCustomer(customer);
    }
}
