package com.users.demo.service;

import com.users.demo.entities.Customer;
import org.json.simple.JSONObject;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    List getAllCustomers();
    Customer getCustomerById(long id);
    void deleteCustomerById(long id);
    void insertCustomer(Customer customer);
    void updateCustomerById(long id, Customer customer);
}
