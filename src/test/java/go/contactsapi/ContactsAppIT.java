package go.contactsapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import go.contactsapi.service.StandardContactDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsAppIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getAllContactsEndPointReturnsListOfContacts() {
		List<StandardContactDTO> contacts = restTemplate
				.getForObject("/contacts", ArrayList.class);
		
		assertThat(contacts).hasSize(2);
	}

}
