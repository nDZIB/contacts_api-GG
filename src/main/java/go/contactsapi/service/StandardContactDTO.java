package go.contactsapi.service;

public class StandardContactDTO {
	
	private long id;
	private String phoneNumber;
	private String name;

	public StandardContactDTO(long id, String name, String phoneNumber) {
		this.setId(id);
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
