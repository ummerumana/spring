package com.users.demo.controller;

import com.users.demo.entities.Customer;
import com.users.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/student")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get{id}")
    Customer getCustomerById(@PathVariable("id") int id)
    {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "remove{id}" )
    int deleteCustomerById(@PathVariable("id") int id)
    {
        return customerService.deleteCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "update{id}")
    boolean updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer)
    {
        return customerService.updateCustomer(id, customer);
    }

    @RequestMapping(method = RequestMethod.POST,value = "insert{id}")
    boolean insertCustomer(@PathVariable("id") int id , @RequestBody Customer customer){
        return customerService.insertCustomer(id,customer);
    }
}
