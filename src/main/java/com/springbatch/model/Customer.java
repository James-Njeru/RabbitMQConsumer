package com.springbatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	private int customer_id;
	private String customer_name;
	private String email;
	
	public Customer() {
	}

	public Customer(int customer_id, String customer_name, String email) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.email = email;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", email=" + email + "]";
	}
	
}
