package com.users.demo.dao;

import com.users.demo.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerDao {
    List getAllCustomers();
    Customer getCustomerById(int id);
    void deleteCustomerById(int id);
    void insertCustomer(Customer customer);
    void updateCustomerById(int id,Customer customer);
}
