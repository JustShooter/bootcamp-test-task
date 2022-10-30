package by.justshooter.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link by.justshooter.repository.entity.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoInput implements Serializable {

    @NotBlank(message = "Must not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]+$", message = "Must be name")
    @Length(max = 40)
    private String secondName;

    @NotBlank(message = "Must not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]+$", message = "Must be name")
    @Length(max = 20)
    private String firstName;

    @NotBlank(message = "Must not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]+$", message = "Must be name")
    @Size(max = 40)
    private String middleName;

    @Email(message = "Must be email")
    @NotBlank(message = "Must not be blank")
    @Length(max = 50)
    private String eMail;

    @NotBlank
    @Pattern(regexp = "Administrator|Sale User|Customer User|Secure API User", message = "Send correct role")
    private String role;
}