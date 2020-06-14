package org.fasttrackit.persistance;

import org.fasttrackit.transfer.CreateContactRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
