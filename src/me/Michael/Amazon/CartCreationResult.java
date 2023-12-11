package me.Michael.Amazon;

public class CartCreationResult {
	private boolean success;
	private String cartID;
	 
	public CartCreationResult(boolean success, String cartID) {
		this.success = success;
		this.cartID = cartID;
	}
	
	public boolean successful() {
		return this.success;
	}
	
	public String getCartID() {
		return this.cartID;
	}
}