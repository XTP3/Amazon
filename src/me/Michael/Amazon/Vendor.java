package me.Michael.Amazon;

public class Vendor {
	private String vendorID, vendorName, email;
	private long phoneNumber, routingNumber, accountNumber;
	
	public Vendor(String vendorID, String vendorName, long phoneNumber, String email, long routingNumber, long accountNumber) {
		this.vendorID = vendorID;
		this.vendorName = vendorName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.routingNumber = routingNumber;
		this.accountNumber = accountNumber;
	}
	
	public String getVendorID() {
		return this.vendorID;
	}
	
	public String getVendorName() {
		return this.vendorName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public long getRoutingNumber() {
		return this.routingNumber;
	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
}
