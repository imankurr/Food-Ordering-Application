package com.Ankur.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Ankur.food.model.Customer;
import com.Ankur.food.model.MenuItem;
import com.Ankur.food.model.Order;
import com.Ankur.food.service.CustomerService;
import com.Ankur.food.service.MenuService;
import com.Ankur.food.service.OrderService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    // View all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // View all menu items
    @GetMapping("/menu")
    public List<MenuItem> getAllMenuItems() {
        return menuService.getAllItems();
    }

    // View all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // (Optional) Delete customer
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        boolean removed = customerService.deleteCustomer(id);
        return removed ? "Customer deleted" : "Customer not found";
    }

    // (Optional) Delete menu item
    @DeleteMapping("/menu/{id}")
    public String deleteMenuItem(@PathVariable int id) {
        boolean removed = menuService.deleteItem(id);
        return removed ? "Menu item deleted" : "Menu item not found";
    }
}
