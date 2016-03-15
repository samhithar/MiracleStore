package com.mss.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TBL_customer")
public class Customer {

	@Id
	@Column(name = "customer_id", nullable = false)
	@NotBlank
	private String customerId;
	@Column(name = "firstname", nullable = false)
	@NotBlank
	private String firstname;
	@Column(name = "lastname", nullable = false)
	@NotBlank
	private String lastname;
	@Column(name = "password", nullable = false)
	@NotBlank
	private String password;
	@Column(name = "email", nullable = false)
	@NotBlank
	@Email
	private String email;
	@Column(name = "enabled", columnDefinition = "boolean default true", nullable = false)
	private Boolean enabled = true;
	@Column(name = "is_admin", columnDefinition = "boolean default false", nullable = false)
	private Boolean isAdmin = false;
	@Transient
	@NotBlank
	private String confirmPassword;

	@OneToMany(mappedBy="customer")	
	private Set<Address> addresses;
	
	@OneToMany(mappedBy="customer")	
	private Set<Order> orders;
	
	
	public Customer() {

	}
	
	public Customer(String customerId, String firstname, String lastname,
			String password, String email) {
		super();
		System.out.println("1");
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}


	public Customer(String customerId, String firstname, String lastname,
			String password, String email, Boolean enabled) {
		super();
		System.out.println("2");
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
	}


	public Customer(String customerId, String firstname, String lastname,
			String password, Boolean enabled, Boolean isAdmin, String email) {
		super();
		System.out.println("3");
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.enabled = enabled;
		this.isAdmin = isAdmin;
		this.email = email;
	}
	
	public Customer(String CustomerId, String password){
		super();
		this.customerId = CustomerId;
		this. password  = password;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean enabled() {
		return enabled;
	}

	public void setActive(Boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
