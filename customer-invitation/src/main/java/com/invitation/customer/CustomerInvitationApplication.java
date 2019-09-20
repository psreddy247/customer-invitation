package com.invitation.customer;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.invitation.customer.TO.CustomerTO;

/**
 * @author Srikanth Reddy
 * Starts the application and invoke to print customers within 100km from intercom office
 */
@SpringBootApplication
public class CustomerInvitationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerInvitationApplication.class, args);
		CustomerInvitation customerInvitation = new CustomerInvitation();
		
		// CustomerInvitation class is responsible print the customers to invite
		List<CustomerTO> invitationList = customerInvitation.findCustomersForInvitation();
		//Print the results.
		customerInvitation.printCustomersForInvitation(invitationList);
	}
}
