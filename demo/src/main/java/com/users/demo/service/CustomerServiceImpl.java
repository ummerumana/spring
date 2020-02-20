package com.users.demo.service;

import com.users.demo.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerServiceImpl implements CustomerService{
    private static Map<Integer, Customer> customers;

    static
    {
        customers = new
                HashMap<Integer, Customer>(){
                    {
                        put(1, new Customer(1, "demo", "..", "demo@gmail.com", "bangalore", 9876543));
                    }
        };
    }
    @Override
    public Collection<Customer> getAllCustomers() {
        return this.customers.values();
    }

    @Override
    public Customer getCustomerById(int id) {
        return this.customers.get(id);
    }

    @Override
    public int deleteCustomerById(int id) {
        return this.customers.remove(id).getId();
    }

    @Override
    public boolean insertCustomer(int id,Customer customer) {

        if(customers.containsKey(id))
        return false;
        customers.put(id,customer);
        return true;
    }

    @Override
    public boolean updateCustomer(int id,Customer customer) {

        if(id == customers.put(customer.getId(),customer).getId())
        return true;
        else
        return false;
    }

}
