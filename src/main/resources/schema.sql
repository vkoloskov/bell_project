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
    organization_id INTEGER NOT NULL,
    FOREIGN KEY (organization_id) REFERENCES Organization (id)
    );
CREATE INDEX Office_id on Office(id);

CREATE TABLE IF NOT EXISTS Citizenship
(
    code VARCHAR(50) COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    name VARCHAR(50) NOT NULL COMMENT 'Название'
    );

CREATE TABLE IF NOT EXISTS Doc_Type
(
    code VARCHAR(50) COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    name VARCHAR(50) NOT NULL COMMENT 'Имя'
);

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
    citizenship_code VARCHAR(50) NOT NULL COMMENT 'Гражданство',
    office_id        INTEGER     NOT NULL,
    FOREIGN KEY (office_id) REFERENCES Office (id),
    FOREIGN KEY (citizenship_code) REFERENCES Citizenship (code),
    );
CREATE INDEX User_id ON User(id);

CREATE TABLE IF NOT EXISTS Document
(
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    doc_number VARCHAR(50) NOT NULL COMMENT 'Номер',
    doc_date   VARCHAR(50) NOT NULL COMMENT 'Отчество',
    doc_code   VARCHAR(50) NOT NULL COMMENT 'Код документа',
    user_id    INTEGER     NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (doc_code) REFERENCES Doc_Type (code),
);
CREATE INDEX Document_user_id ON Document(user_id);




