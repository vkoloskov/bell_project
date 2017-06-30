CREATE TABLE IF NOT EXISTS `Person` (
    `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `version`    INTEGER NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `age`        INTEGER  NOT NULL
);