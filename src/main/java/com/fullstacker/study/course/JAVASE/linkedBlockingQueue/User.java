package com.fullstacker.study.course.JAVASE.linkedBlockingQueue;

public class User {
	private String name;
	private String address;
	private int age;

	public User() {

	}

	public User(String name, String adsress, int age) {
		this.name = name;
		this.age = age;
		this.address = adsress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
