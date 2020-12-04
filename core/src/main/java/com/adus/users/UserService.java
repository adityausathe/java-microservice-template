package com.adus.users;

import com.adus.api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getAllUserNames() {
        return List.of(new User("user_foo"), new User("user_bar"));
    }

    public User getUser(String username) {
        return new User(username, "Name of " + username);
    }
}
