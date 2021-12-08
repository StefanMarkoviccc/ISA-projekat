package app.isa.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String phoneNumber;

    private String description;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus registrationStatus;

    public String getRole() {
        return userType.toString();
    }
}
