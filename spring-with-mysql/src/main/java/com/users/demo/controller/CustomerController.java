package com.users.demo.controller;

import com.users.demo.entities.Customer;
import com.users.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/home")
    public String homePage(){
        return "home";
    }

        @RequestMapping("/index")
        public String indexpage(Model model) {
            model.addAttribute("customers",customerService.getAllCustomers());
            return "index";
        }

        @GetMapping("/signup")
        public String showSignUpForm(Customer customer) {
            return "addUser";
        }

        @PostMapping("/adduser")
        public String addUser(@Valid Customer customer, BindingResult result, Model model) {
            if (result.hasErrors()) {
                System.out.println(result.getAllErrors());
                System.out.println("error");
                return "addUser";
            }

            customerService.insertCustomer(customer);
            System.out.println("successful");
            model.addAttribute("customers", customerService.getAllCustomers());
            return "index";
        }

        @GetMapping("/edit/{id}")
        public String showUpdateForm(@PathVariable("id") int id, Model model) {
            Customer customer = customerService.getCustomerById(id);
            model.addAttribute("customer", customer);
            return "updateUser";
        }

        @PostMapping("/update/{id}")
        public String updateUser(@PathVariable("id") int id, @Valid Customer customer, BindingResult result, Model model) {
            if (result.hasErrors()) {
                customer.setId(id);
                return "updateUser";
            }

            customerService.insertCustomer(customer);
            model.addAttribute("customers", customerService.getAllCustomers());
            return "index";
        }

    @GetMapping("/remove/{id}")
    public String removedUser(@PathVariable("id") int id,Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "deleteUser";
    }
        @GetMapping("/delete/{id}")
        public String deleteUser(@PathVariable("id") int id, Model model) {
            customerService.deleteCustomerById(id);
            model.addAttribute("customers", customerService.getAllCustomers());
            return "index";
        }

}
