package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Customer;
import com.example.demo.dao.ICustomerDao;
@Service
public class ICustomerImpl implements ICustomerService{
   @Autowired
	private ICustomerDao repo;
	@Override
	public List<Customer> getCustomers() {
		System.out.print(repo.findAll());
		return repo.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		System.out.println(customer);
	    repo.save(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return repo.getReferenceById(customerId);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		repo.deleteById(customerId);
	}

}
