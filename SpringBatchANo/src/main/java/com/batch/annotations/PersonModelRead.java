package com.batch.annotations;


//TO READ THE DATA USING ITEMREADER
public class PersonModelRead {
	
	private int id;
	private String name;
	private int salary1;
	private int salary2;
	
	
	public PersonModelRead() {
		super();

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
	public int getSalary1() {
		return salary1;
	}
	public void setSalary1(int salary1) {
		this.salary1 = salary1;
	}
	public int getSalary2() {
		return salary2;
	}
	public void setSalary2(int salary2) {
		this.salary2 = salary2;
	}
	
	

}
