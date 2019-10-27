package go.contactsapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import go.contactsapi.service.ContactsService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsController.class)
public class ContactsControllerTest {

	@Autowired
	private MockMvc contactsController;

	@MockBean
	private ContactsService contactsService;

	// verify that the end point's response status is okay
	@Test
	public void contactsControllerGetAllContactsEndpointsIsUp() throws Exception{
		when(contactsService.getAllContacts()).thenReturn(Arrays.asList());

		RequestBuilder getAllContactsRequest = MockMvcRequestBuilders.get("/contacts")
				.accept(MediaType.APPLICATION_JSON);

		contactsController.perform(getAllContactsRequest)
							.andExpect(status().isOk());
	}

	//verrify that the get all contacts response is okay
	@Test
	public void contactsControllerGetAllContactsEndpointIsReturningAValidList() throws Exception{
		when(contactsService.getAllContacts()).thenReturn(Arrays.asList());

		RequestBuilder getAllContactsRequest = MockMvcRequestBuilders.get("/contacts")
				.accept(MediaType.APPLICATION_JSON);
		

		contactsController.perform(getAllContactsRequest)
							.andExpect(content().json("[]"));
	}

}
