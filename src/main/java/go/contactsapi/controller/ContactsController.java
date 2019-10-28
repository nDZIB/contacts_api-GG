package go.contactsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import go.contactsapi.service.ContactsService;
import go.contactsapi.service.StandardContactDTO;

@RestController
@CrossOrigin
public class ContactsController {
	
	@Autowired
	public ContactsService contactsService;

	@GetMapping("/contacts")
	public List<StandardContactDTO> getAllContacts() {
		return contactsService.getAllContacts();
	}
}
