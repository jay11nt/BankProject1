package in.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bank.entity.Address;

public interface AddressRepo  extends JpaRepository<Address, Integer>
{
	
}
