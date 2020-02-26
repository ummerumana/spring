package com.users.demo.controller;

import com.users.demo.entities.Customer;
import com.users.demo.service.CustomerService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    Customer getCustomerById(@PathVariable("id") int id)
    {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{id}" )
    void deleteCustomerById(@PathVariable("id") int id)
    {
        customerService.deleteCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
    void updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer)
    {
        customerService.updateCustomerById(id, customer);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insert/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void insertCustomer(@RequestBody Customer customer){
        customerService.insertCustomer(customer);
    }
}
