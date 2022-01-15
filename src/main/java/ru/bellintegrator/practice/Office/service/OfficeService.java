package ru.bellintegrator.practice.Office.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.view.OfficeAddView;
import ru.bellintegrator.practice.Office.view.OfficeListView;
import ru.bellintegrator.practice.Office.view.OfficeUpdateView;
import ru.bellintegrator.practice.Office.view.OfficeView;
import javax.validation.Valid;

import java.util.List;
@Validated
public interface OfficeService {

    List<OfficeListView> getOffices(Long orgId, String name, Boolean isActive);

    OfficeView getOffice(Long id);

    void add(@Valid OfficeAddView officeView);

    void update(@Valid OfficeUpdateView officeUpdateView);


}
