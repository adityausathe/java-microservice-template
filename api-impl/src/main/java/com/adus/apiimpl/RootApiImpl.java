package com.adus.apiimpl;

import com.adus.api.RootApi;
import com.adus.api.UserApi;
import com.adus.api.model.ApiModule;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RootApiImpl implements RootApi {

    @Override
    public EntityModel<ApiModule> getModule() {
        ApiModule rootApiModule = new ApiModule(RootApi.ROOT_API_CODE, "Root Module")
                .withSubModule(
                        EntityModel.of(new ApiModule(UserApi.USERS_API_CODE, "User Module"))
                                .add(linkTo(methodOn(UserApi.class).getAllUsers()).withSelfRel())
                );
        return EntityModel.of(rootApiModule)
                .add(linkTo(methodOn(RootApi.class).getModule()).withSelfRel());
    }
}
