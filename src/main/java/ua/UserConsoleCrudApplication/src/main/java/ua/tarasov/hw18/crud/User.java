package ua.tarasov.hw18.crud;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
class User {

    private String firstName;
    private String lastName;
    private String fullName;
    private String id;
    private String email;
}
