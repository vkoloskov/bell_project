package ru.bellintegrator.practice.Office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Office.dao.OfficeDao;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.filter.OfficeFilter;
import ru.bellintegrator.practice.Office.view.OfficeView;
import ru.bellintegrator.practice.mapper.MapperFacade;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public List<OfficeView> getOffices(Long orgId, String name, Boolean isActive) {


        return officeDao.getAll(orgId, name, isActive);
    }

    @Override
    @Transactional
    public OfficeView getOffice(Long id) {
        Office entity = officeDao.loadById(id);
        return mapperFacade.map(entity, OfficeView.class);
    }

}
