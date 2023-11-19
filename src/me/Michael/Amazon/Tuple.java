package me.Michael.Amazon;

// DEPRECATED

public class Tuple {
	private String x, y, z, v;
	
	public Tuple(String x, String y, String z, String v) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.v = v;
	}
	
	public String get(int index) {
		switch(index) {
			case 0:
				return this.x;
			case 1:
				return this.y;
			case 2:
				return this.z;
			case 3:
				return this.v;
			default:
				return this.x;
		}
	}
}
