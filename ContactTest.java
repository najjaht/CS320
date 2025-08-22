package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test //Ensures contact class accepts valid entries
	 void testContactClass() { 
		Contact contact = new Contact("Contact", "Jane", "Doe", "1234567890", "101 Market St");
		assertTrue(contact.getContactId().equals("Contact"));
		assertTrue(contact.getFirstName().equals("Jane"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("101 Market St"));
		
	}
	
	@Test //Throws an exception if contact ID exceeds 10 characters
	 void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact8901", "Jane", "Doe", "1234567890", "101 Market St");
		});
	}
	
	@Test //Throws an exception if contact ID is null
	 void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Jane", "Doe", "1234567890", "101 Market St");
		});
	}
	
	@Test //Throws an exception if first name exceeds 10 characters
	 void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane5678901", "Doe", "1234567890", "101 Market St");
		});
	}
	
	@Test //Throws an exception if first name is null
	 void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", null, "Doe", "1234567890", "101 Market St");
		});
	}
	
	@Test //Throws an exception if last name exceeds 10 characters
	 void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe45678901", "1234567890", "101 Market St");
		});
	}
	
	@Test //Throws an exception if last name is null
	 void testLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", null, "1234567890", "101 Market St");
		});
	}

	@Test //Throws an exception if phone exceeds 10 characters
	 void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe", "12345678901", "101 Market St");
		});
	}
	
	@Test //Throws an exception if phone is less than 10 characters
	 void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe", "123456789", "101 Market St");
		});
	}
	
	@Test //Throws an exception if phone contains letters
	 void testPhoneContainLetters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe", "12345a7890", "101 Market St");
		});
	}
	
	@Test //Throws an exception if phone is null
	 void testPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe", null, "101 Market St");
		});
	}
	
	@Test //Throws an exception if address exceeds 30 characters
	 void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe", "1234567890", "1234 Market Street ATL, GA 30339");
		});
	}
	
	@Test //Throws an exception if address is null
	 void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Contact", "Jane", "Doe", "1234567890", null);
		});
	}


}
