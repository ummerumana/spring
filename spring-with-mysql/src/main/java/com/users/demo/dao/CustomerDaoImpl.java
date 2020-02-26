package com.users.demo.dao;


import com.users.demo.entities.Customer;
import com.users.demo.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired()
    private UserRepository userRepository;


    @Override
    public List getAllCustomers() {
        return (List) userRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return (Customer) userRepository.findById((id)).get();
    }

    @Override
    public void deleteCustomerById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void insertCustomer(Customer customer) {
        userRepository.save(customer);
    }

    @Override
    public void updateCustomerById(int id, Customer customer) {
        Customer cust = (Customer) userRepository.findById(id).get();
        cust = customer;
        userRepository.save(cust);

    }
}
