package com.codermine.cookbook.controller;

import com.codermine.cookbook.model.Dose;
import com.codermine.cookbook.service.DoseService;
import com.fasterxml.jackson.core.JsonParseException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.hateoas.JsonError;
import io.micronaut.http.hateoas.Link;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller(DoseController.DOSES_CONTROLLER)
@Tag(name = "Doses", description = "Endpoint for Doses management")
public class DoseController {

    public static final String DOSES_CONTROLLER = "/doses";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private DoseService doseService;

    @Post
    @Operation(summary = "Insert a Dose", description = "Insert a Dose.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public Dose post(Dose dose) {
        logger.debug("DoseController - post - start - dose: {}", dose);
        Dose savedDose = doseService.insertDose(dose);
        logger.debug("DoseController - get - stop - savedDose: {}", savedDose);
        return savedDose;
    }

    //global error handler
    @Error(global = true)
    public HttpResponse<JsonError> jsonError(HttpRequest request, JsonParseException jsonParseException) {
        JsonError error = new JsonError("Invalid JSON: " + jsonParseException.getMessage())
                .link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.<JsonError>status(HttpStatus.BAD_REQUEST, "Fix Your JSON")
                .body(error);
    }
}
