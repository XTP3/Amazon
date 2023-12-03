package me.Michael.Amazon;

public class User {
	private String userID, username, password, role;
	private String firstName, lastName, state, city, zipCode, streetAddress, billingType, email;
	private boolean primeStatus;
	private int cardNumber, phoneNumber;
	
	public User(String userID, String username, String password, String role) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public void setCustomerDetails(String firstName, String lastName, String state, String city, String zipCode, String streetAddress, String billingType, int cardNumber, boolean primeStatus, int phoneNumber, String email) {
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
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getFormattedRole() {
		return this.role.substring(0, 1).toUpperCase() + this.role.substring(1).toLowerCase();
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

    public int getCardNumber() {
        return this.cardNumber;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean getPrimeStatus() {
        return this.primeStatus;
    }
}