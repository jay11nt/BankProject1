package in.bank.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotNull
	@Size(min=3,max=15,message = "first name should not be empty")
	private String firstName;
	
	@NotNull
	@Size(min = 3,max = 15,message = "maiden name should not be empty=enter mother/father name")
	private String maidenName;
	
	@NotNull
	@Size(min = 3,max = 15,message = "last name should not be empty")
	private String lastName;
	
	@NotNull
	private String gender;
	
	@NotNull
	@Size(min=3,max=15,message = "mother name should not be empty")
	private String motherName;
	
	@NotNull
	@Size(min=3,max=15,message = "father name should not be empty")
	private String fatherName;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateofBirth;
	
	@NotNull
	@Pattern(regexp = "^[A-Z]{5}$",message = "first five letter in capital only ")
	private String panNumber;
	
	@NotNull
	@Digits(integer=10,fraction = 0,message = "mobile number should be 10 digit only")
	private Long mobNumber;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{12}$",message = "aadhar no should be 12 digit only")
	private String aadharNumber;
	
	@NotNull
	@Pattern(regexp = "Student|Self-Employed|Service|Business|Retired|Housewife|Other", message = "Invalid occupation type")
	private String occupationType;
	
	@NotNull
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
}
