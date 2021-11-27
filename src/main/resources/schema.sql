CREATE TABLE IF NOT EXISTS Person (
                                      id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
                                      version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
                                      first_name VARCHAR(50) NOT NULL COMMENT 'Имя',
    age        INTEGER  NOT NULL    COMMENT 'Возраст'
    );
COMMENT ON TABLE Person IS 'Человек';

CREATE TABLE IF NOT EXISTS House (
                                     id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
                                     version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
                                     address    VARCHAR(50) NOT NULL COMMENT 'Адрес'
    );
COMMENT ON TABLE House IS 'Дом';

CREATE TABLE IF NOT EXISTS Person_House (
                                            person_id   INTEGER  NOT NULL COMMENT 'Уникальный идентификатор человека',
                                            house_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор дома',

                                            PRIMARY KEY (person_id, house_id)
    );
COMMENT ON TABLE Person_House IS 'join-таблица для связи человека и дома';

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House ADD FOREIGN KEY (house_id) REFERENCES House(id);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House ADD FOREIGN KEY (person_id) REFERENCES Person(id);



CREATE TABLE IF NOT EXISTS Organization
(
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name      VARCHAR(50) NOT NULL COMMENT 'Имя',
    full_name VARCHAR(50) NOT NULL COMMENT 'Имя',
);
CREATE INDEX Organization_id on Organization(id);

CREATE TABLE IF NOT EXISTS Office
(
    id       INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name     VARCHAR(50) NOT NULL COMMENT 'Имя',
    address  VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone    VARCHAR(50) NOT NULL COMMENT 'Телефон',
    is_active BOOLEAN,
    organization_id INTEGER     NOT NULL,
    FOREIGN KEY (organization_id) REFERENCES Organization (id)
    );
CREATE INDEX Office_id on Office(id);

CREATE TABLE IF NOT EXISTS Citizenship
(
    code INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    name VARCHAR(50) NOT NULL COMMENT 'Название'
    );

CREATE TABLE IF NOT EXISTS DocType
(
    code INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    name VARCHAR(50) NOT NULL COMMENT 'Имя'
);

CREATE TABLE IF NOT EXISTS Document
(
    id         INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    doc_name   VARCHAR(50) NOT NULL COMMENT 'Имя',
    doc_number VARCHAR(50) NOT NULL COMMENT 'Номер',
    doc_date   VARCHAR(50) NOT NULL COMMENT 'Отчество',
    doc_code   INTEGER     NOT NULL COMMENT 'Код документа',
    FOREIGN KEY (doc_code) REFERENCES DocType (code),
);
CREATE INDEX Document_id ON Document(id);

CREATE TABLE IF NOT EXISTS User
(
    id               INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version          INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    first_name       VARCHAR(50) NOT NULL COMMENT 'Имя',
    last_name        VARCHAR(50) NOT NULL COMMENT 'Фамилия',
    middle_name      VARCHAR(50) NOT NULL COMMENT 'Отчество',
    position         VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone            VARCHAR(50) NOT NULL COMMENT 'Телефон',
    is_identified    BOOLEAN COMMENT 'Идентифицирован?',
    citizenship_code INTEGER     NOT NULL COMMENT 'Гражданство',
    office_id        INTEGER     NOT NULL,
    document_id        INTEGER     NOT NULL,
    FOREIGN KEY (office_id) REFERENCES Office (id),
    FOREIGN KEY (citizenship_code) REFERENCES Citizenship (code),
    FOREIGN KEY (document_id) REFERENCES Document (id)
    );
CREATE INDEX User_id ON User(id);




