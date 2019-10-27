package go.contactsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import go.contactsapi.model.Contact;
import go.contactsapi.service.ContactsService;

@RestController
public class ContactsController {
	
	@Autowired
	public ContactsService contactsService;

	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {
		return contactsService.getAllContacts();
	}
}
