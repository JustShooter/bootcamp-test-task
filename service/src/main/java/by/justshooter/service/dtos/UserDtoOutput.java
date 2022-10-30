package by.justshooter.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link by.justshooter.repository.entity.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoOutput implements Serializable {
    private String fullName;
    private String eMail;
    private String role;
}