package org.fasttrackit.persistance;

import javafx.concurrent.Task;
import org.fasttrackit.domain.Contact;
import org.fasttrackit.transfer.CreateContactRequest;
import org.fasttrackit.transfer.UpdateContactRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {

    public void createContact(CreateContactRequest request) throws IOException, SQLException, ClassNotFoundException {
        String sql = "INSERT INTO contact (first_name, last_name, phone_number) VALUES (?, ?, ?)";

        //try-with-resources
        try (Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getPhoneNumber());

            preparedStatement.executeUpdate();
        }
    }

    public void updateContact(long id, UpdateContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE contact SET first_name=?, last_name=?, phone_number=? WHERE id=?";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getPhoneNumber());
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();
        }

    }

    public void deleteTask(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM contact WHERE id=?;";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }

    public List<Contact> getContacts() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT id, first_name, last_name, phone_number FROM contact";

        List<Contact> contacts = new ArrayList<>();

        try(Connection connection = DatabaseConfiguration.getConnection();
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Contact contact = new Contact();

                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setPhoneNumber(resultSet.getString("phone_number"));

                contacts.add(contact);
            }
        }

        return contacts;
    }
}




