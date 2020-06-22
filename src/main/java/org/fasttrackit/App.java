package org.fasttrackit;

import org.fasttrackit.domain.Contact;
import org.fasttrackit.persistance.ContactRepository;
import org.fasttrackit.transfer.CreateContactRequest;
import org.fasttrackit.transfer.UpdateContactRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
//        CreateContactRequest request = new CreateContactRequest();
//        request.setFirstName("Flaviu");
//        request.setLastName("Ratiu");
//        request.setPhoneNumber("0723913123");

        ContactRepository contactRepository = new ContactRepository();
//        contactRepository.createContact(request);

//        UpdateContactRequest updateRequest = new UpdateContactRequest();
//        updateRequest.setFirstName("Flaviu");
//        updateRequest.setLastName("Ratiu");
//        updateRequest.setPhoneNumber("2342342322");

//        contactRepository.updateContact(1, updateRequest);

//        contactRepository.deleteTask(1);

        List<Contact> contacts = contactRepository.getContacts();
        System.out.println(contacts);
    }
}
