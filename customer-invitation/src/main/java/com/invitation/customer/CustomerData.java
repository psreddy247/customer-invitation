package com.invitation.customer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;

import com.invitation.customer.TO.CustomerTO;

public class CustomerData {

	public List<CustomerTO> getCustomerData() {
		List<CustomerTO> customerList = new ArrayList<CustomerTO>();
		// Read customer data form a file customer.txt
		Path path = null;
		try {
			path = Paths.get(getClass().getClassLoader().getResource("customers.txt").toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Stream<String> stream = Files.lines(path)) {
		   // stream.forEach(System.out::println);
		    customerList = stream.map(s -> {
		    	JSONObject jsonObject = new JSONObject(s);
		    	CustomerTO customerTO = new CustomerTO();
		    	customerTO.setUserId(jsonObject.getLong("user_id"));
		    	customerTO.setName(jsonObject.getString("name"));
		    	customerTO.setLatitude(jsonObject.getDouble("latitude"));
		    	customerTO.setLongitude(jsonObject.getDouble("longitude"));
		    	return customerTO;
		    }).collect(Collectors.toList());
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return customerList;
	}
}
