package myApp.services;

import myApp.models.User;
import myApp.services.Interfaces.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final List<User> users = new ArrayList<>();
    private int userIdCounter = 1;

    @Override
    public Long countAllUsers() {
        return (long) users.size();
    }

    @Override
    public User getById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getByLastName(String lastName) {
        return users.stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getByPhone(String phone) {
        return users.stream()
                .filter(user -> user.getPhone().equals(phone))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAdmins() {
        return users.stream()
                .filter(User::isAdmin)
                .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create(User user) {
        user.setId(userIdCounter++);
        users.add(user);
    }

    @Override
    public void update(User user, User logUser) {
        User existingUser = getById(user.getId());
        if (existingUser != null) {
            if (logUser.isAdmin() || logUser.getId() == user.getId()) {
                existingUser.setUsername(user.getUsername());
                existingUser.setLastName(user.getLastName());
                existingUser.setEmail(user.getEmail());
                existingUser.setPhone(user.getPhone());
                existingUser.setAdmin(user.isAdmin());
            } else {
                throw new SecurityException("Not authorized to update this user.");
            }
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public void delete(int id, User logUser) {
        User user = getById(id);
        if (user != null) {
            if (logUser.isAdmin() || logUser.getId() == id) {
                users.remove(user);
            } else {
                throw new SecurityException("Not authorized to delete this user.");
            }
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public User getUserDetails(int id) {
        return getById(id);
    }

    @Override
    public User blockUser(int id, User logUser) {
        if (!logUser.isAdmin()) {
            throw new SecurityException("Only admins can block users.");
        }

        User user = getById(id);
        if (user != null) {
            user.setBlocked(true);
            return user;
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public User unBlockUser(int id, User logUser) {
        if (!logUser.isAdmin()) {
            throw new SecurityException("Only admins can unblock users.");
        }

        User user = getById(id);
        if (user != null) {
            user.setBlocked(false);
            return user;
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public User makeAdmin(int id, User logUser) {
        if (!logUser.isAdmin()) {
            throw new SecurityException("Only admins can promote users.");
        }

        User user = getById(id);
        if (user != null) {
            user.setAdmin(true);
            return user;
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public User demoteAdmin(int id, User logUser) {
        if (!logUser.isAdmin()) {
            throw new SecurityException("Only admins can demote users.");
        }

        User user = getById(id);
        if (user != null) {
            user.setAdmin(false);
            return user;
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }
}
