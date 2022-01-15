package ru.bellintegrator.practice.Office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Office.dao.OfficeDao;
import ru.bellintegrator.practice.Office.entity.Office;
import ru.bellintegrator.practice.Office.view.OfficeAddView;
import ru.bellintegrator.practice.Office.view.OfficeListView;
import ru.bellintegrator.practice.Office.view.OfficeUpdateView;
import ru.bellintegrator.practice.Office.view.OfficeView;
import ru.bellintegrator.practice.Organization.dao.OrganizationDao;
import ru.bellintegrator.practice.Organization.entity.Organization;
import ru.bellintegrator.practice.mapper.MapperFacade;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public List<OfficeListView> getOffices(Long orgId, String name, Boolean isActive) {
        List<Office> offices = officeDao.getAll(orgId, name, isActive);
        return mapperFacade.mapAsList(offices,OfficeListView.class);
    }

    @Override
    @Transactional
    public OfficeView getOffice(Long id) {
        Office entity = officeDao.loadById(id);
        return mapperFacade.map(entity, OfficeView.class);
    }

    @Override
    @Transactional
    public void add(OfficeAddView officeView) {
        Office office = mapperFacade.map(officeView, Office.class);
        Organization organization = getOrganization(officeView.orgId);
        office.setOrganization(organization);
        officeDao.save(office);
    }

    @Override
    @Transactional
    public void update(OfficeUpdateView officeUpdateView) {
        Office office = officeDao.loadById(officeUpdateView.id);
        office.setName(officeUpdateView.name);
        office.setAddress(officeUpdateView.address);
        if(officeUpdateView.isActive != null) {
            office.setIsActive(officeUpdateView.isActive);
        }
        if(officeUpdateView.phone != null) {
            office.setPhone(officeUpdateView.phone);
        }
        officeDao.save(office);

    }

    private Organization getOrganization(long id) {
        Organization organization = organizationDao.loadById(id);
        return organization;
    }

}
