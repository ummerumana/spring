package com.users.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.demo.entities.Customer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Repository
public class CustomerServiceImpl implements CustomerService{
    private File file = new File("/home/ummerummana/Documents/customers/details.json");

    private FileWriter fw;
    private FileReader fr;

    private static Map<Integer, Customer> customers;

    @Override
    public Collection<JSONObject> getAllCustomers() {
        Collection<JSONObject> c = new ArrayList<JSONObject>();
        try {
            fr = new FileReader(file);
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();
            JSONArray customerList = (JSONArray) jsonParser.parse(fr);
            System.out.println(customerList);
            for(int i=0;i<customerList.size();i++) {
                JSONObject cust = (JSONObject) customerList.get(i);
                c.add(cust);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public int deleteCustomerById(int id) {
        return customers.remove(id).getId();
    }

    @Override
    public boolean insertCustomer(int id,Customer customer) {
        ObjectMapper Obj = new ObjectMapper();

        try {
            fw = new FileWriter(file);
            String jsonStr = Obj.writeValueAsString(customer);
            System.out.println(jsonStr);
            JSONObject jObject = new JSONObject();
            jObject.put(id, jsonStr);

            JSONArray customerList = new JSONArray();
            customerList.add(jObject);

            fw.write(customerList.toJSONString());
            //fw.write(jsonStr);
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
