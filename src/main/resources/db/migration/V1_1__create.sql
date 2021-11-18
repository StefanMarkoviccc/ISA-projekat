DROP TABLE IF EXISTS 'user';

CREATE TABLE 'user' (
)

CREATE TABLE 'house'(
    'id' bigint(20) NOT NULL AUTO_INCREMENT
    'user_id' bigint(20) NOT NULL
    'name' varchar(255) NOT NULL,
    'address' varchar(255) NOT NULL,
    'geographical_width' decimal(19,4) NOT NULL
    'geographical_length' decimal(19,4) NOT NULL
    'description' varchar(255) NOT NULL
    'rules_of_conduct' varchar(255) NOT NULL
    PRIMARY KEY ('id')
    FOREIGN KEY (user_id) REFERENCES user('id')
)

CREATE TABLE 'navigation'
    'id' bigint(20) NOT NULL AUTO_INCREMENT
    'name' varchar(255) NOT NULL
    'boat_id' bigint(20) NOT NULL
    PRIMARY KEY ('id')
    FOREIGN KEY (boat_id) REFERENCES boat('id')

CREATE TABLE 'room'
    'id' bigint(20) NOT NULL AUTO_INCREMENT
    'room_number' varchar(20) NOT NULL
    'number_of_beds' bigint(20) NOT NULL
    'house_id' bigint(20) NOT NULL
    PRIMARY KEY ('id')
    FOREIGN KEY (house_id) REFERENCES house('id')