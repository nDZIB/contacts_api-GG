package go.contactsapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import go.contactsapi.service.ContactsServiceTests;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsController.class)
public class ContactsControllerTest {

	@InjectMocks
	private MockMvc contactsController;

	@MockBean
	private ContactsService contactsService;

	// verify that the end point is okay
	@Test
	public void contactsControllerGetAllContactsEndpointsIsUp() {
		when(contactsService.getAllContacts()).thenReturn(Arrays.asList());

		RequestBuilder getAllContactsRequest = MockMvcRequestBuilders.get("/contacts")
				.accept(MediaType.APPLICATION_JSON);

		contactsController.perform(getAllContactsRequest).andExpect(status().isOk());
	}

	@Test
	public void contactsControllerGetAllContactsEndpointIsReturningAValidList() {
		when(contactsService.getAllContacts()).thenReturn(Arrays.asList());

		RequestBuilder getAllContactsRequest = MockMvcRequestBuilders.get("/contacts")
				.accept(MediaType.APPLICATION_JSON);
		

		MvcResult allContacts = contactsController.perform(getAllContactsRequest)
							.andExpect(content().json("[]"))
							.andReturn();
		//incomplete test
	}

}
