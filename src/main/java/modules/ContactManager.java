package modules;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ContactManager {
    Map<String,Contact> contactList= new ConcurrentHashMap<String,Contact>();
    public void addContact(String firstName,String lastName,String phoneNumber){
      Contact contact=new Contact(firstName,lastName,phoneNumber);
      validateContact(contact);
      checkIfContactAlreadyExisted(contact);
      contactList.put(generateKey(contact),contact);
    }

//    public int getAllContacts(ContactManager contactManager){
//        return contactManager.contactList.size();
//    }

    public Collection<Contact> getAllContacts(){
        return contactList.values();
    }
    private String generateKey(Contact contact) {
        return String.format("%s%s", contact.getFirstName(),contact.getLastName());
    }

    private void checkIfContactAlreadyExisted(Contact contact) {
        if(contactList.containsKey(generateKey(contact))){
            throw new RuntimeException("Contact Already Existed");
        }
    }

    private void validateContact(Contact contact) {
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }
}
