package by.justshooter.controller;

import by.justshooter.service.UserService;
import by.justshooter.service.dtos.UserDtoInput;
import by.justshooter.service.dtos.UserDtoOutput;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDtoOutput> getAllUsers(){
        logger.info("getAllUsers");
        return userService.getAllUsers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewUser(@RequestBody UserDtoInput newUser){
        logger.info("createNewUser" + newUser);
        userService.createNewUser(newUser);
    }
}
