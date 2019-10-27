package go.contactsapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import go.contactsapi.model.Contact;
import go.contactsapi.model.repository.ContactsRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContactsServiceTests {

	@Mock
	private ContactsRepository contactsRepository;
	@InjectMocks
	private ContactsService contactsService;
	
	
	@Test
	public void contactServiceGetAllContactsMethodReturnsListOfContacts() {
		when(contactsRepository.findAll())
				.thenReturn(Arrays.asList(new Contact(1, "Bruno N.", "6745690")));
		
		assertThat(contactsService.getAllContacts()).asList().isNotNull();
	}
	
	//verify that the phone numbers obtained from contacts are valid i.e have 9 characters for
	//cameroon
	
	@Test
	public void contactServceReturnsContactsWithValidPhoneNumbers() {
		
		when(contactsRepository.findAll()).thenReturn(Arrays
				.asList(new Contact(1, "Bruno Ndzi", "671349364")));
		
		assertThat(contactsService.getAllContacts()).asList().allSatisfy(contact -> {
			assertThat(((Contact)contact).getPhoneNumber()).hasSize(9);
			assertThat(((Contact)contact).getPhoneNumber()).doesNotContainAnyWhitespaces();
			//contact name does not contain punction marks or characters marks
			assertThat(((Contact)contact).getPhoneNumber()).containsOnlyDigits();
			//verify that each contact starts with a 6 or a 2
			assertThat(((Contact)contact).getPhoneNumber())
					.matches(Pattern.compile("[62][0-9]*"));
		});
	}
}
