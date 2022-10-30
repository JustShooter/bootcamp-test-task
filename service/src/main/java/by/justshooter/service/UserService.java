package by.justshooter.service;

import by.justshooter.service.dtos.UserDtoInput;
import by.justshooter.service.dtos.UserDtoOutput;

import java.util.List;

public interface UserService {
    List<UserDtoOutput> getAllUsers();

    UserDtoInput createNewUser(UserDtoInput newUser);
}
