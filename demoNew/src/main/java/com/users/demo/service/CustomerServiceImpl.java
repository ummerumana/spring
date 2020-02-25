package com.users.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import com.users.demo.entities.Customer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository
public class CustomerServiceImpl implements CustomerService{
    private File file = new File("/home/ummerummana/Documents/customers/details.txt");

    private FileWriter fw;
    private FileReader fr;
    private BufferedReader br;

    private static Map<Integer, Customer> customers;

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> cList = new ArrayList<Customer>();
        ObjectMapper obj = new ObjectMapper();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String st;
            while ((st = br.readLine()) != null){
                Customer c1 = obj.readValue(st,Customer.class);
                cList.add(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cList;
    }

    @Override
    public Customer getCustomerById(int id) {
        ObjectMapper obj = new ObjectMapper();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String st;
            while ((st = br.readLine()) != null){
                Customer c1 = obj.readValue(st,Customer.class);
                if(c1.getId()==id)
                    return c1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Customer();
    }

    @Override
    public int deleteCustomerById(int id) {
        ObjectMapper obj = new ObjectMapper();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String st;
            while ((st = br.readLine()) != null){
                Customer c1 = obj.readValue(st,Customer.class);
                if(c1.getId()==id){

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean insertCustomer(int id,Customer customer) {
        ObjectMapper Obj = new ObjectMapper();

        try {
            fw = new FileWriter(file,true);

            String jsonStr = Obj.writeValueAsString(customer);
            fw.append(jsonStr);
            fw.append("\n");
            fw.flush();
            fw.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(int id,Customer customer) {

        if(id == customers.put(customer.getId(),customer).getId())
        return true;
        return false;
    }

}
