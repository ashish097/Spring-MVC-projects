package com.batch.annotations;

//TO WRITE DATA USING ITEMWRITER
public class PersonModelWrite {
	
	private int id;
	private String name;
	private int totalsalry;
	
	
	public PersonModelWrite(int id, String name, int totalsalry) {
		super();
		this.id = id;
		this.name = name;
		this.totalsalry = totalsalry;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalsalry() {
		return totalsalry;
	}
	public void setTotalsalry(int totalsalry) {
		this.totalsalry = totalsalry;
	}
	
    
}
