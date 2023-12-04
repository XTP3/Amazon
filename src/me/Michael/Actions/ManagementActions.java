package me.Michael.Actions;

import me.Michael.Amazon.Queries;
import me.Michael.Utils.QueryDisplayer;

public class ManagementActions {
	
	public static void getAllProducts() {
		new QueryDisplayer(Queries.getAllProducts());
	}
	
	public static void getAllCustomers() {
		new QueryDisplayer(Queries.getAllCustomers());
	}
	
	public static void getAllVendors() {
		new QueryDisplayer(Queries.getAllVendors());
	}
	
	public static void getAllOrders() {
		new QueryDisplayer(Queries.getAllOrders());
	}
	
	public static void getAllSales() {
		new QueryDisplayer(Queries.getAllSales());
	}
	
	public static void getAllCarts() {
		new QueryDisplayer(Queries.getAllCarts());
	}
	
	public static void getAllWishlists() {
		new QueryDisplayer(Queries.getAllWishlists());
	}
	
	public static void getAllMusic() {
		new QueryDisplayer(Queries.getAllMusic());
	}
	
	public static void getAllVideos() {
		new QueryDisplayer(Queries.getAllVideos());
	}
}
