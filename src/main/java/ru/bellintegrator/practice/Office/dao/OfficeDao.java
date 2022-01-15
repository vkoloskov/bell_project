package ru.bellintegrator.practice.Office.dao;

import ru.bellintegrator.practice.Office.entity.Office;


import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {

    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> getAll(Long orgId, String name, Boolean isActive);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office loadById(Long id);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void save(Office office);
}