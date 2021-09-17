package com.atlan.DatabaseExportService.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String created;

    public static String[] getName() {
        return new String[]{"id", "firstName", "lastname", "dateOfBirth", "created"};
    }

    public static String[] getDisplayName() {
        return new String[]{"User ID", "First Name", "Last Name", "Date of Birth", "Date Created"};
    }
}