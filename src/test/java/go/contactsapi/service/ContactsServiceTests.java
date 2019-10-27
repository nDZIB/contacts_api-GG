package go.contactsapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import go.contactsapi.model.repository.Contact;
import go.contactsapi.model.repository.ContactsRepository;

public class ContactsServiceTests {

	@MockBean
	private ContactsRepository contactsRepository;
	
	private ContactsService contactsService;
	
	
	@Test
	private void contactServiceGetAllContactsMethodReturnsListOfContacts() {
		
		when(contactsRepository.findAll()).thenReturn(Arrays.asList());
		
		assertThat(contactsService.getAllContacts()).asList();
	}
	
	//verify that the phone numbers obtained from contacts are valid i.e have 9 characters for
	//cameroon
	
	@Test
	public void contactServceReturnsContactsWithValidPhoneNumbers() {
		
		when(contactsRepository.findAll()).thenReturn(Arrays
				.asList(new Contact(1, "Bruno Ndzi", "671349364")));
		
		assertThat(contactsService.getAllContacts()).asList().allSatisfy(contact -> {
			assertThat(((Contact)contact).getName()).hasSize(9);
			assertThat(((Contact)contact).getName()).doesNotContainAnyWhitespaces();
			//contact name does not contain punction marks or characters marks
			assertThat(((Contact)contact).getName()).containsOnlyDigits();
		});
	}
}
