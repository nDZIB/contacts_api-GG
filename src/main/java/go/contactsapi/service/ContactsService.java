package go.contactsapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import go.contactsapi.model.Contact;
import go.contactsapi.model.repository.ContactsRepository;

@Service
public class ContactsService {

	@Autowired
	private ContactsRepository contactsRepository;
	
	public List<StandardContactDTO> getAllContacts() {
		List<StandardContactDTO> contactDTOList = new ArrayList<StandardContactDTO>();
		
		contactsRepository.findAll().forEach( contact -> {
			addToList(contactDTOList, contact);
		});
		
		return contactDTOList;
	}

	
	//helper methods
	private void addToList(List<StandardContactDTO> contactDTOList, Contact contact) {
		contactDTOList.add(contact.toStandardContactDTO());
	}
}
