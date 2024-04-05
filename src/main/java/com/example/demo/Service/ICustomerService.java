package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Customer;

public interface ICustomerService {
	public List<Customer>getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(Integer customerId);
	public void deleteCustomer(Integer customerId);
}
