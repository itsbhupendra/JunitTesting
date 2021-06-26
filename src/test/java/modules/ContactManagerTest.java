package modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    @Test
    public void shouldCreateContact(){
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Bhupendra","Singh","0986754768");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should Not create contact when first name is null")
    public void NullFirstName (){
        ContactManager contactManager =new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact(null,"Singh","0123456789");
        });

    }

}