package com.adus.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ApiModule {
    private String code;
    private String name;
    private List<EntityModel<ApiModule>> subModules;

    public ApiModule(String code, String name) {
        this.code = code;
        this.name = name;
        this.subModules = new ArrayList<>();
    }

    public ApiModule withSubModule(EntityModel<ApiModule> module) {
        this.subModules.add(module);
        return this;
    }

    public ApiModule and(EntityModel<ApiModule> module) {
        return withSubModule(module);
    }
}
