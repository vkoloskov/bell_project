INSERT INTO House (id, version, address) VALUES (1, 0, 'ул.Цюрупы, 16');

INSERT INTO House (id, version, address) VALUES (2, 0, 'ул.Лунина, 7');

INSERT INTO Person (id, version, first_name, age) VALUES (1, 0, 'Пётр', 20);

INSERT INTO Person (id, version, first_name, age) VALUES (2, 0, 'John', 25);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 1);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 2);


INSERT INTO Citizenship (code, name) VALUES (1, 'РФ');
INSERT INTO Organization (id, version, name, full_name) VALUES (1, 0, 'СБЕР', 'ПАО СБЕРБАНК');
INSERT INTO Office(id, version, name, address, phone, is_active, organization_id) VALUES (1, 0, 'Центральный', 'ул.Лунина, 7', '+7-909-000-11-11', true,1);
INSERT INTO DocType (code, name) VALUES (1, 'Паспорт');
INSERT INTO Document (id, version, doc_name, doc_number, doc_date, doc_code) VALUES (1, 0, 'Паспорт', '4141 112333', '01.01.2000', 1);
INSERT INTO User (id, version, first_name, last_name, middle_name, position, phone, is_identified, citizenship_code, office_id, document_id)
VALUES (1, 0, 'Иван', 'Иваново', 'Иванович', 'стажер', '+7-909-000-11-12', true, 1, 1, 1);

