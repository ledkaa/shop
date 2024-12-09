package myApp.controlers;

import myApp.models.User;
import myApp.models.dtos.CreateUserDto;
import myApp.models.dtos.UserDTO;
import myApp.services.Interfaces.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUser(int id) {
        return userService.getById(id);
    }

    public void createUser(CreateUserDto createUserDTO) {
        userService.createUser(createUserDTO);
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}