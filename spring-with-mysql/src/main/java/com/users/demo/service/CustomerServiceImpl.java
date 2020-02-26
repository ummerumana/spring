package com.users.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.demo.dao.CustomerDao;
import com.users.demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public List getAllCustomers() {
       return customerDao.getAllCustomers();
    }

    @Transactional
    public Customer getCustomerById(long id) {
        return customerDao.getCustomerById(id);
    }

    @Transactional
    public void deleteCustomerById(long id) {
       customerDao.deleteCustomerById(id);
    }

    @Transactional
    public void insertCustomer(Customer customer) {
        customerDao.insertCustomer(customer);
    }

    @Transactional
    public void updateCustomerById(long id,Customer customer) {
        customerDao.updateCustomerById(id,customer);
    }

}
