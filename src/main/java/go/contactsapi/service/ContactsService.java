package go.contactsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import go.contactsapi.model.Contact;
import go.contactsapi.model.repository.ContactsRepository;

@Service
public class ContactsService {

	@Autowired
	private ContactsRepository contactsRepository;
	
	public List<Contact> getAllContacts() {
		return contactsRepository.findAll();
	}

}
