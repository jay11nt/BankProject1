package in.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bank.entity.Customer;
import in.bank.exception.CustomerNotFound;
import in.bank.service.CustomerService;
import jakarta.validation.Valid;

@RestController
public class MyController 
{
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer (@Valid @RequestBody Customer customer) throws CustomerNotFound
	{
		Customer customer2 = customerService.saveCustomer(customer);
		
		return new ResponseEntity<Customer> (customer2, HttpStatus.CREATED);			//Http status 
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getByCustomerId (@PathVariable ("id") Integer Id)throws CustomerNotFound
	{
		Customer byCustomerId = customerService.getByCustomerId(Id);
		
		return new ResponseEntity<Customer>(byCustomerId,HttpStatus.FOUND);			//Http status 
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getByAll()throws CustomerNotFound
	{
		List<Customer> byAll = customerService.getByAll();
		
		return new ResponseEntity<List<Customer>>(byAll,HttpStatus.FOUND);			//Http status 
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateByCustomerId(@PathVariable ("id") Integer id)throws CustomerNotFound
	{
		Customer byCustomerId = customerService.updateByCustomerId(id);
		 
		return new ResponseEntity<Customer>(byCustomerId,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteByCustomerId(@PathVariable ("id") Integer id)throws CustomerNotFound
	{
		Customer byCustomerId = customerService.deleteByCustomerId(id);
		
		return new ResponseEntity<Customer>(byCustomerId,HttpStatus.OK);
	}
}
