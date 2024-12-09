package myApp.reposotory.Interfaces;

import myApp.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);
    void save(User user);
    void deleteById(int id);
}
