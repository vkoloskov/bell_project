package ru.bellintegrator.practice.Office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.service.OfficeService;
import ru.bellintegrator.practice.Office.view.OfficeAddView;
import ru.bellintegrator.practice.Office.view.OfficeListView;
import ru.bellintegrator.practice.Office.view.OfficeUpdateView;
import ru.bellintegrator.practice.Office.view.OfficeView;

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
    public List<OfficeListView> offices(@PathVariable(value = "orgId") Long orgId) {
        return officeService.getOffices(orgId,null, null);
    }
    @GetMapping("/{id}")
    public OfficeView office(@PathVariable(value = "id") Long id) {
        return officeService.getOffice(id);
    }

    @ApiOperation(value = "Добавить офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/add")
    public void add(@RequestBody OfficeAddView office) {
        officeService.add(office);
    }

    @ApiOperation(value = "Обновить данные по офису", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void update(@RequestBody OfficeUpdateView office) {
        officeService.update(office);
    }

}
