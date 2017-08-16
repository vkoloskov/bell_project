package ru.bellintegrator.practice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.model.House;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.dao.impl.HouseDAOImpl;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class HouseDAOTest {

    @Autowired
    private HouseDAOImpl houseDAO;

    @Test
    public void test() throws Exception {
        House house = new House();
        List<Person> list = new ArrayList<>();
        house.setAddress("Address");
        Person person = new Person("One", 1);
        person.setHouse(house);
        house.setPersons(list);
        list.add(person);
        houseDAO.save(house);

        List<House> houses = houseDAO.all();
        assert houses != null;

        person.setHouse(house);

        houses = houseDAO.all();
        assert houses.get(1).getPersons().size() == 1;

        Person person1 = new Person("Two", 2);
        list.add(person1);

        houses = houseDAO.all();
        assert houses.get(1).getPersons().size() == 2;
    }
}