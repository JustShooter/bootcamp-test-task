package by.justshooter.service.mapper;

import by.justshooter.repository.entity.User;
import by.justshooter.repository.entity.enums.Role;
import by.justshooter.service.dtos.UserDtoInput;
import by.justshooter.service.dtos.UserDtoOutput;

public class UserMapper {

    public static UserDtoOutput mapUserToOutputDto(User user) {
        return new UserDtoOutput(getFullNameOfUser(user),
                user.getEMail(),
                user.getRole().getName());
    }

    public static User mapUserInputDtoToUser(UserDtoInput user) {
        return User.builder()
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .secondName(user.getSecondName())
                .eMail(user.getEMail())
                .role(Role.getRoleByName(user.getRole()))
                .build();
    }

    private static String getFullNameOfUser(User user) {
        return user.getSecondName()
                + " "
                + user.getFirstName()
                + " "
                + user.getMiddleName();
    }
}
