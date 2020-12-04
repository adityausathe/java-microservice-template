package com.adus.apiimpl;

import com.adus.api.UserApi;
import com.adus.api.model.User;
import com.adus.users.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserApiImpl implements UserApi {
    private final UserService userService;

    public UserApiImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CollectionModel<EntityModel<User>> getAllUsers() {
        List<EntityModel<User>> users = userService.getAllUserNames()
                .stream()
                .map(user -> EntityModel.of(user)
                        .add(linkTo(methodOn(UserApi.class).getUser(user.getUsername())).withSelfRel()))
                .collect(Collectors.toList());
        return CollectionModel.of(users)
                .add(linkTo(methodOn(UserApi.class).getAllUsers()).withSelfRel());
    }

    @Override
    public EntityModel<User> getUser(String username) {
        User user = userService.getUser(username);
        return EntityModel.of(user)
                .add(linkTo(methodOn(UserApi.class).getUser(username)).withSelfRel());
    }
}
