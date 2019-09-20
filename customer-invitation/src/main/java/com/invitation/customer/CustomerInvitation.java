package com.invitation.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.invitation.customer.TO.CustomerTO;
import com.invitation.utils.DistanceUtil;

/**
 * @author P Srikanth Reddy This class is to collect data and print customers
 *         within 100KM from Intercom office
 */
public class CustomerInvitation {
	private final double officeLatitude = 53.339428d;
	private final double officeLongitude = -6.257664d;

	public List<CustomerTO> findCustomersForInvitation() {
		CustomerData customerData = new CustomerData();

		// Below method reads data from the txt file and converts in to java object
		List<CustomerTO> customerList = customerData.getCustomerData();

		List<CustomerTO> invitationList = getCustomersInRange(customerList, officeLatitude, officeLongitude, 100d);
		invitationList = invitationList.stream().sorted((c1, c2) -> new Long(c1.getUserId() - c2.getUserId()).intValue())
				.collect(Collectors.toList());

		return invitationList;
	}

	/**
	 * Below method is used to list all the customers who is within 100km from given
	 * latitude and longitude
	 */
	private List<CustomerTO> getCustomersInRange(List<CustomerTO> allCustomerList, double sourceLatitude,
			double sourceLongitude, double range) {
		List<CustomerTO> invitationList = new ArrayList<CustomerTO>();
		invitationList = allCustomerList.stream().filter(to -> DistanceUtil.findDistance(sourceLatitude,
				sourceLongitude, to.getLatitude(), to.getLongitude()) < range).collect(Collectors.toList());
		return invitationList;
	}

	/**
	 * Printh results
	 */
	public void printCustomersForInvitation(List<CustomerTO> invitationList) {
		invitationList.stream().forEach(c -> {
			System.out.println("UserId: " + c.getUserId() + " Name: " + c.getName()); // Display the output
		});
	}
}
