package tacos.tacocloud.dtos;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.tacocloud.entities.User;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    @NotBlank(message = "Username is required")
    private final String username;

    @NotBlank(message = "Password is required")
    private final String password;

    @NotBlank(message = "Confirm Password is required")
    private final String confirm;

    @NotBlank(message = "Full name is required")
    private final String fullname;

    @NotBlank(message = "Street is required")
    private final String street;

    @NotBlank(message = "City is required")
    private final String city;

    @NotBlank(message = "State is required")
    private final String state;

    @NotBlank(message = "Zip is required")
    private final String zip;

    @NotBlank(message = "Phone is required")
    private final String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username,
                passwordEncoder.encode(password),
                fullname,
                street,
                city,
                state,
                zip,
                phoneNumber
        );
    }
}
