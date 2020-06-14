package org.fasttrackit;

import org.fasttrackit.persistance.ContactRepository;
import org.fasttrackit.transfer.CreateContactRequest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
        CreateContactRequest request = new CreateContactRequest();
        request.setFirstName("Raul");
        request.setLastName("Dobos");
        request.setPhoneNumber("0722201278");

        ContactRepository contactRepository = new ContactRepository();
        contactRepository.createContact(request);

    }
}
