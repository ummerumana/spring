package com.users.demo.service;

import com.users.demo.entities.Customer;
import org.json.simple.JSONObject;

import java.util.Collection;
import java.util.Map;

public interface CustomerService {

    Collection<Customer> getAllCustomers();
    Customer getCustomerById(long id);
    int deleteCustomerById(long id);
    boolean insertCustomer(Customer customer);
    boolean updateCustomerById(long id, Customer customer);
}