package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test //Ensure ability to add contact
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("Contact", "Jane", "Doe", "1234567890", "101 Market St");
		service.addContact(contact);
	}
	
	@Test //Throws exception if added contact is NOT unique
	void testContactIsUnique() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("Contact", "Jane", "Doe", "1234567890", "101 Market St");
		Contact contact2 = new Contact("Contact", "Jane", "Doe", "1234567890", "101 Market St");
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	@Test //Ensures ability to delete contact
	void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("Contact", "Jane", "Doe", "1234567890", "101 Market St");
		service.addContact(contact);
		service.deleteContact("Contact");
	}
	
	@Test //Throws an exception when attempt to delete nonexistent contact entry
	void testDeleteOnNonexistentContact() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("Contact");
		});
	}
	
	@Test //Ensures ability to update contact fields
	void testUpdateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("Contact", "Jane", "Doe", "1234567890", "101 Market St");
		service.addContact(contact);
		service.updateContact("Contact", "Sally", "Sue", "4045551111", "123 Peter Rd");
		assertEquals("Sally", contact.getFirstName());
		assertEquals("Sue",contact.getLastName());
		assertEquals("4045551111", contact.getPhone());
		assertEquals("123 Peter Rd", contact.getAddress());
	}
	
	@Test //Throws an exception when attempt to update nonexistent contact entry
	void testUpdateOnNonexistentContact() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("Contact", "Sally", "Sue", "4045551111", "123 Peter Rd");
		});
	}

}
