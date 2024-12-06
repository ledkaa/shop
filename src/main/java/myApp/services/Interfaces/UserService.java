package myApp.services.Interfaces;

import myApp.models.User;

import java.util.List;

public interface UserService {
    //  public List<User> getAll(UserFilterOptions userFilterOptions, User logUser);


    Long countAllUsers();


    User getById(int id);

    User getByUsername(String username);

    User getByLastName(String lastName);

    User getByPhone(String phone);

    List<User> getAdmins();

    User getByEmail(String email);

    void create(User user);

    void update(User user, User logUser);

    void delete(int id, User logUser);

    User getUserDetails(int id);

    User blockUser(int id, User user);

    User unBlockUser(int id, User user);

    User makeAdmin(int id, User user);

    User demoteAdmin(int id, User user);
}
