package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.view.PersonView;

import java.util.List;

/**
 * Сервис
 */
public interface PersonService {

    /**
     * Добавить нового человека в БД
     *
     * @param person
     */
    void add(PersonView person);

    /**
     * Получить список людей
     *
     * @return {@Person}
     */
    List<PersonView> persons();
}