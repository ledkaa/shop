package myApp.reposotory;

import myApp.models.User;
import myApp.reposotory.Interfaces.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserReposotoryImpl implements UserRepository {
    private final Map<Integer, User> database = new HashMap<>();
    private int idCounter = 1;

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return database.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(idCounter++);
        }
        database.put(user.getId(), user);
    }

    @Override
    public void deleteById(int id) {
        database.remove(id);
    }
}
