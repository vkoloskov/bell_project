package ru.bellintegrator.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.PersonDAO;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.service.ProxyTest;

import java.util.UUID;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ProxyTestImpl implements ProxyTest {
    private static final Logger log = LoggerFactory.getLogger(ProxyTestImpl.class);

    private final PersonDAO dao;

    @Autowired
    private ProxyTest self;

    @Autowired
    ProxyTestImpl(PersonDAO dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updatePersons() {
        Person person = new Person(
                UUID.randomUUID().toString(),
                1000
        );
        dao.save(person);
    }

    @Transactional
    @Override
    public void allPersons() {
        self.updatePersons();
        long count = dao.count();
        log.info("Persons count: {}", count);
        throw new RuntimeException("Rollback transaction");
    }
}
