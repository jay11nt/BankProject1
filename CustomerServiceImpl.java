package in.bank.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.bank.entity.Customer;
import in.bank.exception.CustomerNotFound;
import in.bank.repo.CustomerRepo;
import in.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService		//here we implements the service (customerService)
{									// (customerService) is interface
	@Autowired
	private CustomerRepo customerRepo;

	
	@Override
	public Customer saveCustomer(Customer customer) throws CustomerNotFound
	{
		if(customer!=null)
		{
			Customer customer2 = customerRepo.save(customer);
			return customer2;
		}
		
		throw new CustomerNotFound("customer details should not be null");
	}

	@Override
	public Customer getByCustomerId(Integer CustomerId) throws CustomerNotFound
	{
		Optional<Customer> byId = customerRepo.findById(CustomerId);
		if(byId.isPresent())
		{
			Customer found =byId.get();
			return found;
		}
		
		
		throw new CustomerNotFound("Customer not found with this Id: "+ CustomerId);
	}

	@Override
	public List<Customer> getByAll() throws CustomerNotFound 
	{
		List<Customer> all = customerRepo.findAll();
		if(all==null)
		{
			throw new CustomerNotFound("all customer list not found");
		}
		return all;
	}

	@Override
	public Customer updateByCustomerId(Integer CustomerId) throws CustomerNotFound
	{
		Optional<Customer> byId = customerRepo.findById(CustomerId);
		if(byId.isPresent())
		{
			Customer updated =byId.get();
			return updated;
		}
		throw new CustomerNotFound("Customer is not updating error");
	}

	@Override
	public Customer deleteByCustomerId(Integer CustomerId) throws CustomerNotFound
	{
		 Customer object = customerRepo.findById(CustomerId).orElseThrow(()-> new CustomerNotFound("Customer not found for deletion"));
		
		return object;
	}
	
	
	
	
	
	
}
