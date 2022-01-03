package ru.bellintegrator.practice.Office.service;

import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    List<Office> getOffices(Long orgId, String name, Boolean isActive);

    OfficeView getOffice(Long id);

}
