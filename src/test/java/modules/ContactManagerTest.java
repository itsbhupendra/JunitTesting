package modules;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {
    public ContactManager contactManager;

    @BeforeAll
    public static void setupAll(){
        System.out.println("Before All");
    }
    @BeforeEach
    public void setup(){
        contactManager=new ContactManager();
    }

    @Test
    public void shouldCreateContact(){
//        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Bhupendra","Singh","0986754768");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should Not create contact when first name is null")
    public void NullFirstName (){
//        ContactManager contactManager =new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact(null,"Singh","0123456789");
        });

    }
    @Test
    @DisplayName("OS Machine")
    public void ShouldTestOS(){
        Assumptions.assumeFalse("MAC".equals(System.getProperty("ENV")));
        contactManager.addContact("Bhupendra","Singh","0986754768");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());


    }
    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }
    @AfterAll
    public static void tearDownAll(){
        System.out.println("After All");
    }

}