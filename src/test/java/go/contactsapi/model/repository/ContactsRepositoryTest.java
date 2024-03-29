package go.contactsapi.model.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ContactsRepositoryTest {

	@Autowired
	private ContactsRepository contactsRepository;
	
	
	@Test
	public void contactsRepositoryFindAllMethodReturnsValuesTest() {
		//verify that a valid list object is returned
		assertThat(contactsRepository.findAll()).asList().isNotNull();
	}
	
	@Test 
	public void contactsRepositoryFindAllMethodReturnsAllContactsFromDatabaseTest() {
		//verify that the size of the returned list is 2, since two contacts are preloaded 
		//into the database
		assertThat(contactsRepository.findAll()).asList().size().isEqualTo(2);
	}
}
