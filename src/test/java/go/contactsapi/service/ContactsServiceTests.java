package go.contactsapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
		when(contactsRepository.findAll())//mock the contacts repository
				.thenReturn(Arrays.asList(new Contact(1, "Bruno N.", "674569091")));
		//verify that a valid object is returned
		assertThat(contactsService.getAllContacts()).asList().isNotNull();
	}
	
	
	//verify that each contact returned from repository is valid
	@Test
	public void contactRepositoryFindAllMethodReturnsValidContactsTest() {
		when(contactsRepository.findAll())//mock the contacts repository
			.thenReturn(Arrays.asList(new Contact(1, "Bruno N.", "674569090"),
									  new Contact(2, "Ndzi B.", "689012479")));
		
		assertThat(contactsService.getAllContacts()).asList().allSatisfy(contact -> {
			assertThat(((StandardContactDTO) contact).getId(), isA(Long.class));
			assertThat(((StandardContactDTO) contact).getName()).isNotNull();
			assertThat(((StandardContactDTO) contact).getPhoneNumber()).isNotNull();
		});
	}
	
	//verify that the phone numbers obtained from contacts are valid i.e have 9 characters
	@Test
	public void contactServceReturnsContactsWithValidPhoneNumbers() {
		
		when(contactsRepository.findAll()).thenReturn(Arrays
				.asList(new Contact(1, "Bruno Ndzi", "671349364")));
		
		assertThat(contactsService.getAllContacts()).asList().allSatisfy(contact -> {//for each contact in the list,
																						// verify that it is valid
			//contact phone number is exactly 9 characters long (a valid cameroon number)
			assertThat(((StandardContactDTO)contact).getPhoneNumber()).hasSize(9);
			//contact phone number does not contain any white spaces
			assertThat(((StandardContactDTO)contact).getPhoneNumber()).doesNotContainAnyWhitespaces();
			//contact phone number does not contain alphabetic characters
			assertThat(((StandardContactDTO)contact).getPhoneNumber()).containsOnlyDigits();
			//verify that each contact starts with a 6 or a 2
			assertThat(((StandardContactDTO)contact).getPhoneNumber()).matches(Pattern.compile("[62][0-9]*"));
		});
	}
}
