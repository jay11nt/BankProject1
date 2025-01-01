package in.bank.service;

import java.util.List;

import in.bank.entity.Customer;
import in.bank.exception.CustomerNotFound;

public interface CustomerService 
{
	public Customer saveCustomer (Customer customer)throws CustomerNotFound;
	
	public Customer getByCustomerId (Integer CustomerId)throws CustomerNotFound;
	
	public List<Customer> getByAll()throws CustomerNotFound;
	
	public Customer updateByCustomerId(Integer CustomerId)throws CustomerNotFound;
	
	public Customer deleteByCustomerId (Integer CustomerId)throws CustomerNotFound;
}
