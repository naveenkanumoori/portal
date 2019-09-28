package com.naveen.portal.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column 
	private Date dateofbirth;
		
	@Column
	private String username;
	
	
	public Profile() {
		super();
	}

	public Profile(String firstname, String lastname, String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public void fromRegister(Register register) throws Exception{
		this.title = register.getTitle();
		this.firstname = register.getFirstname();
		this.lastname = register.getLastname();
		this.username = register.getUsername();
		this.email = register.getEmail();
		this.phone = register.getPhone();
		String sdateofbirth = register.getDateofbirth();
		Date dateofbirth = null;
		
		if (sdateofbirth != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			try {
				dateofbirth = formatter.parse(sdateofbirth); 
			} catch (Exception e) {
				throw new Exception("Problem parsing Date of Birth");
			}
		}
		this.dateofbirth = dateofbirth;
	}
	
}
