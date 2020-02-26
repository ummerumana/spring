package com.users.demo.dao;

import com.users.demo.entities.Customer;

import java.util.Collection;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Collection<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerById(long id) {
        return null;
    }

    @Override
    public int deleteCustomerById(long id) {
        return 0;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomerById(long id, Customer customer) {
        return false;
    }
}
