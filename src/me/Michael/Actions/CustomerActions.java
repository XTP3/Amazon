package me.Michael.Actions;

import me.Michael.Amazon.Queries;
import me.Michael.Utils.QueryDisplayer;

public class CustomerActions {

	public static void getAllProducts() {
		new QueryDisplayer(Queries.getAllProducts());
	}
}
