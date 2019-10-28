package go.contactsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import go.contactsapi.service.StandardContactDTO;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String phonenumber;
	
	public Contact() {
	}

	public Contact(long id, String name, String phonenumber) {
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}
	
	public StandardContactDTO toStandardContactDTO() {
		return new StandardContactDTO(getId(), getName(), getPhoneNumber());
	}
}
