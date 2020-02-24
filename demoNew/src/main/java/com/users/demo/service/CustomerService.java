package com.users.demo.service;

import com.users.demo.entities.Customer;

import java.util.Collection;
import java.util.Map;

public interface CustomerService {

    Collection<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    int deleteCustomerById(int id);
    boolean insertCustomer(int id, Customer customer);
    boolean updateCustomer(int id, Customer customer);
}
