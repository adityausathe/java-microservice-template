package com.adus.templateapp.api;

import com.adus.templateapp.api.model.ApiModule;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/")
public interface RootApi {
    String API_PREFIX = "/api/v1";

    String ROOT_API_CODE = "root_api";

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<ApiModule> getModule();
}
