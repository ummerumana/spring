package com.users.demo.service;

import com.users.demo.entities.Customer;
import org.json.simple.JSONObject;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    List getAllCustomers();
    Customer getCustomerById(int id);
    void deleteCustomerById(int id);
    void insertCustomer(Customer customer);
    void updateCustomerById(int id, Customer customer);
}
