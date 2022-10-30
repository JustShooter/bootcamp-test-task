package by.justshooter.service.impl;

import by.justshooter.repository.UserRepository;
import by.justshooter.repository.entity.User;
import by.justshooter.service.UserService;
import by.justshooter.service.dtos.UserDtoInput;
import by.justshooter.service.dtos.UserDtoOutput;
import by.justshooter.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public List<UserDtoOutput> getAllUsers() {
        logger.info("getAllUsers");
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapUserToOutputDto)
                .sorted(Comparator.comparing(UserDtoOutput::getEMail))
                .collect(Collectors.toList());
    }

    @Override
    public UserDtoInput createNewUser(UserDtoInput newUser) {
        logger.info("createNewUser" + newUser);
        User user = userRepository.save(UserMapper.mapUserInputDtoToUser(newUser));
        return UserMapper.mapUserToUserInputDto(user);
    }
}
