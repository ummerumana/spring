package com.users.demo.dao;

import com.users.demo.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerDao {
    List getAllCustomers();
    Customer getCustomerById(long id);
    void deleteCustomerById(long id);
    void insertCustomer(Customer customer);
    void updateCustomerById(long id,Customer customer);
}
