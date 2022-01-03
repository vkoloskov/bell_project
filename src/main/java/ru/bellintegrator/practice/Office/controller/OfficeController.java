package ru.bellintegrator.practice.Office.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.filter.OfficeFilter;
import ru.bellintegrator.practice.Office.service.OfficeService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/list/{orgId}")
    public List<Office> offices(@PathVariable(value = "orgId") Long orgId) {
        return officeService.getOffices(orgId,null, null);
    }
    @GetMapping("/{id}")
    public OfficeFilter office(@PathVariable(value = "id") Long id) {
        return officeService.getOffice(id);
    }

}
