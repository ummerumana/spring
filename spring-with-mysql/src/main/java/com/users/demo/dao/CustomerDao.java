package com.users.demo.dao;

import com.users.demo.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerDao {
    Collection<Customer> getAllCustomers();
    Customer getCustomerById(long id);
    int deleteCustomerById(long id);
    boolean insertCustomer(Customer customer);
    boolean updateCustomerById(long id,Customer customer);
}
