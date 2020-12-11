package com.adus.templateapp.api;


import com.adus.templateapp.api.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(RootApi.API_PREFIX + "/users")
public interface UserApi {
    String USERS_API_CODE = "users_api";

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<EntityModel<User>> getAllUsers();

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<User> getUser(@PathVariable("username") String username);

}
