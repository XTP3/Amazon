package me.Michael.Amazon;

public class Customer {
	private String firstName, lastName, state, city, zipCode, streetAddress, billingType, email;
	private boolean primeStatus;
	private long cardNumber, phoneNumber;
	
	public Customer(String firstName, String lastName, String state, String city, String zipCode, String streetAddress, String billingType, long cardNumber, boolean primeStatus, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.streetAddress = streetAddress;
		this.billingType = billingType;
		this.cardNumber = cardNumber;
		this.primeStatus = primeStatus;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
    public String getState() {
        return this.state;
    }

    public String getCity() {
        return this.city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getBillingType() {
        return this.billingType;
    }

    public long getCardNumber() {
        return this.cardNumber;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean getPrimeStatus() {
        return this.primeStatus;
    }
}
