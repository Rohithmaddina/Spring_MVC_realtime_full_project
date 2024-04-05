package com.example.demo.Model;



import org.springframework.stereotype.Controller;

import lombok.Data;
import javax.persistence.Entity;
@Entity
//@Table(name="customer")
@Data
public class Customer {
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@javax.persistence.Id
	private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    
}

