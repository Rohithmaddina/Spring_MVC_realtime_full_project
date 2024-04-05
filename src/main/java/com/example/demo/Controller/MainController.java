package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Customer;
import com.example.demo.Service.ICustomerService;
@Controller
public class MainController {
	@Autowired
	private ICustomerService service;
	@GetMapping("/list")
public String getCusomerDetails(Map<String, Object>model)
{
	List<Customer>customers=service.getCustomers();
	System.out.print("after servicd");
	model.put("customers",customers);
	customers.forEach(System.out::println);
	return "customer-list";
}
	@GetMapping("/showForm")
	public String showFormAdd(Map<String, Object>model)
	{
		Customer customer=new Customer();
		model.put("customer", customer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		   System.out.println("savecustomer"+customer);
			service.saveCustomer(customer);
			return "redirect:/list";
	}
	@GetMapping("showFormForUpdate")
	public String updateCustomerDetails(@RequestParam("customerId")Integer id,Map<String, Object>model)
	{
		Customer customer=service.getCustomer(id);
		model.put("customer", customer);
		System.out.println(customer);
		return "customer-form";
	}
	@GetMapping("showFormForDelete")
	public String PerformDelete(@RequestParam Integer customerId) {
		service.deleteCustomer(customerId);
		System.out.println("Customer is deleted successfully");
		return "redirect:/list";
	}
}
