package in.bank.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	
	 @NotNull
	    private String addressType;  		// Address type: "Permanent", "Temporary", etc.
	    private String homeNo;
	    private String pincode;
	    private String street;
	    private String city;
	    private String state;
	    private String country;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)	//relationship mapping to Customer
	private Customer customer;
}
