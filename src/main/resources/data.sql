INSERT INTO Citizenship (code, name) VALUES ('01', 'РФ');
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, is_active, phone) VALUES (1, 0, 'СБЕР', 'ПАО СБЕРБАНК','11','222','111',true, '111');
INSERT INTO Office(id, version, name, address, phone, is_active, organization_id) VALUES (1, 0, 'Центральный', 'ул.Лунина, 7', '+7-909-000-11-11', true,1);
INSERT INTO Doc_Type (code, name) VALUES ('01', 'Паспорт');
INSERT INTO User (id, version, first_name, last_name, middle_name, position, phone, is_identified, citizenship_code, office_id)
VALUES (1, 0, 'Иван', 'Иваново', 'Иванович', 'стажер', '+7-909-000-11-12', true, '01', 1);
INSERT INTO Document (version, doc_number, doc_date, doc_code, user_id) VALUES ( 0, '4141 112333', '01.01.2000', '01', 1);


