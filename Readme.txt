I have created spring-boot application. The main parts of the application are given below.
1. Reading the customer information from a text file. (CustomerData.java)
2. Finding their distance from intecom office. (DistanceUtil.java)
3. Filter and order the customerList by the distance(<100km) from intercom office. (CustomerInvitation.java)
4. Printing the customer user id and name. (CustomerInvitation.java)

Installations 
Java 1.8 or later
Maven 3.2

Steps to run the application:
1. Open command prompt and go to folder 'CustomerInvite\customer-invitation'.
2. Run below commands to clean, build and run application
	a) mvn clean
	b) mvn install
	c) mvn spring-boot:run

The application prints the output(The names and user ids of matching customers (within 100km), sorted by User ID) on the consol.

Note: need to update customer.txt to test for different data. 
