package com.cloth.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.cloth.ServiceImpl.Customer_Service_impl;
import com.cloth.ServiceImpl.Money_b_service;
import com.cloth.ServiceImpl.Stock_Service_impl;
import com.cloth.ServiceImpl.Tailor_Service_impl;

import com.cloth.model.Customer;
import com.cloth.model.Money_b;
import com.cloth.model.Stock_info;
import com.cloth.model.Tailor;

@Controller
//@RequestMapping("/clothes_billing")
public class MainController {
	@Autowired
	private Stock_Service_impl impl;

	@Autowired
	private Customer_Service_impl cus_impl;

	@Autowired
	private Money_b_service service;

	@Autowired
	private Tailor_Service_impl service_t;

	@GetMapping("/Dashboard")
	public String dashboard() {
		return "Dashboard";
	}

	@GetMapping("/stockForm")
	public String showStockForm(Model model) {
		model.addAttribute("stock", new Stock_info()); // Initialize a new Stock_info object for the form
		return "Stock.html"; // Thymeleaf template name (stock_form.html)
	}

	@PostMapping("/SaveStock")
	public String saveStock(@ModelAttribute("stock") Stock_info stock) {
		impl.Save_Stock(stock);

		return "Stock.html";
	}

	@GetMapping("/stock")
	public String showStockPage(Model model) {
		List<Stock_info> stockList = impl.getAllStock(); // Retrieve all stock information from service/dao
		model.addAttribute("stockList", stockList); // Add the stockList to the model
		return "Stock_display"; // Thymeleaf template name (Stock_display.html)
	}

	// <Customer Information>

	@GetMapping("/CustomerForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());

		return "CustomerPage.html";
	}

	@PostMapping("/SaveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		try {
			cus_impl.Save_Customer(customer);
			return "redirect:/Dashboard";
		} catch (RuntimeException e) {
			// Handle the exception to show alert message to the user
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("customer", customer); // Add customer back to the model for re-rendering form
			return "CustomerPage.html";
		}
	}

	@GetMapping("/Customers")
	public String getCustomerList(Model model) {
		List<Customer> customerList = cus_impl.getAllCustomer(); // Example: Fetching customer data from service
		model.addAttribute("customerList", customerList);
		return "Cust_display.html"; // Thymeleaf template name
	}

	@GetMapping("/editCustomer/{id}")
	public String showEditCustomerForm(@PathVariable Long id, Model model) {
		Customer customer = cus_impl.getCustomerById(id);
		if (customer == null) {
			throw new RuntimeException("Customer not found with id: " + id);
		}
		model.addAttribute("customer", customer);
		return "EditCustomer.html"; // Thymeleaf template name for edit customer form
	}

	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute("customer") Customer updatedCustomer) {
		cus_impl.updateCustomer(updatedCustomer); // Implement this method in service
		return "redirect:/Customers"; // Redirect to customer list after update
	}

	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") Long id) {
		cus_impl.deleteCustomer(id); // Implement this method in service
		return "redirect:/Customers"; // Redirect to customer list after delete
	}

	@GetMapping("/Money_b")
	public String showMoney_b(Model model) {
		// model.addAttribute("money", new Money_b()); // Ensure money object is added
		// to the model
		model.addAttribute(model);
		return "Money_Page.html";
	}

	@PostMapping("/submit_money")
	public String saveMoney(@Validated @ModelAttribute("money") Money_b money_b, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Money_Page.html"; // Return the form view if validation errors are present
		}
		service.moneySave(money_b);
		return "redirect:/Money_b"; // Redirect to prevent form resubmission
	}

	@GetMapping("/money_bs")
	public String getMoney_bList(Model model) {
		List<Money_b> MoneyList = service.getAllMoney1(); // Example: Fetching customer data from service
		model.addAttribute("MoneyList", MoneyList);
		return "Money_display.html"; // Thymeleaf template name
	}

	@GetMapping("/tailorform")
	public String Form(Model model) {
		model.addAttribute("tailor", new Tailor());

		return "tailor.html";
	}

	@PostMapping("/SaveTailor")
	public String tailor(@ModelAttribute("tailor") Tailor tailor, Model model) {

		service_t.Save_Tailor(tailor);
		return "redirect:/Dashboard";

	}

	@GetMapping("/showTailor")
	public String getTailorList(Model model) {
		List<Tailor> TailorList = service_t.getAllTailor(); // Example: Fetching customer data from service
		model.addAttribute("TailorList", TailorList);
		return "showTailor"; // Thymeleaf template name
	}

	@PostMapping("/deleteTailo/{id}")
	public String deleteTailor(@PathVariable("id") Long id, @ModelAttribute("customer") Customer updatedCustomer) {
		service_t.deleteTailor(id); // Implement this method in service
		return "redirect:/showTailor"; // Redirect to customer list after update
	}

	@GetMapping("/editTailor/{id}")
	public String showEditTailorForm(@PathVariable Long id, Model model) {
		Tailor tailor = service_t.getTailorById(id);
		if (tailor == null) {
			throw new RuntimeException("Tailor not found with id: " + id);
		}
		model.addAttribute("tailor", tailor); // Make sure the attribute name is "tailor"
		return "EditTailor"; // Ensure this matches your Thymeleaf template name
	}

	@PostMapping("/updateTailor/{id}")
	public String updateTailor(@PathVariable("id") Long id, @ModelAttribute("tailor") Tailor updatedTailor) {
		service_t.updateTailor(updatedTailor);
		return "redirect:/showTailor"; // Redirect to customer list after update
	}

}
