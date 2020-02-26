package com.users.demo.dao;


import com.users.demo.entities.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllCustomers() {
        return sessionFactory.getCurrentSession().createQuery("from customer").list();
    }

    @Override
    public Customer getCustomerById(long id) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class,id);
    }

    @Override
    public void deleteCustomerById(long id) {
        sessionFactory.getCurrentSession().delete(getCustomerById(id));
    }

    @Override
    public void insertCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public void updateCustomerById(long id, Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }
}
