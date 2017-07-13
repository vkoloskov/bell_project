package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.DummyController;
import ru.bellintegrator.practice.service.DummyService;
import ru.bellintegrator.practice.view.PersonView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class DummyControllerImpl implements DummyController {
    private final Logger log = LoggerFactory.getLogger(DummyControllerImpl.class);

    private final DummyService dummyService;

    private final TaskExecutor executor;

    @Autowired
    public DummyControllerImpl(DummyService dummyService, TaskExecutor executor) {
        this.dummyService = dummyService;
        this.executor = executor;
    }

    @Override
    @RequestMapping(value = "/ping", method = {GET, POST})
    public String ping() {
        return "pong";
    }

    @Override
    @ApiOperation(value = "addPerson", nickname = "addPerson", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/person", method = {POST})
    public void person(@RequestBody PersonView person) {
        dummyService.add(person);
    }

    @Override
    @ApiOperation(value = "getPersons", nickname = "getPersons", httpMethod = "GET")
    @RequestMapping(value = "/person", method = {GET})
    public List<PersonView> persons() {
        return dummyService.persons();
    }

}
