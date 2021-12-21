package ru.bellintegrator.practice.Office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Office.dao.OfficeDao;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.filter.OfficeFilter;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    @Override
    public List<Office> getOffices(Long orgId, String name, Boolean isActive) {

        OfficeFilter filter = new OfficeFilter(orgId, name, isActive);

        return officeDao.getAll(filter);
    }

    @Override
    public OfficeFilter getOffice(Long id) {
        Office entity = officeDao.loadById(id);
        return new OfficeFilter(entity.getId(),entity.getName(),entity.getIsActive());
    }

}
