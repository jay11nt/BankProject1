package in.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bank.entity.Customer;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
	List<Customer> findByfirstName (String firstName);
	 List<Customer> findByfirstNameAndGender (String firstName, String gender);
	 List<Customer> findByfirstNameAndOccupationType (String firstName, String occupationType);
	 
}
