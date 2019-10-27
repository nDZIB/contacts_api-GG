package go.contactsapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import go.contactsapi.model.Contact;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Long>{

}
