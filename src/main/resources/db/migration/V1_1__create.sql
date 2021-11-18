DROP TABLE IF EXISTS 'user';

CREATE TABLE 'user' (
    'id' bigint(20) NOT NULL AUTO_INCREMENT,
    'email' varchar(255) NOT NULL,
    'password' varchar(255) NOT NULL,
    'first_name' varchar(255) NOT NULL,
    'last_name' varchar(255) NOT NULL,
    'address' varchar(255) NOT NULL,
    'city' varchar(255) NOT NULL,
    'country' varchar(255) NOT NULL,
    'phone_number' varchar(255) NOT NULL,
    'user_type' varchar(255) NOT NULL,
    'description' varchar(255) NOT NULL,
    'registration_status' varchar(255) NOT NUll,
    PRIMARY KEY('id')
)

DROP TABLE IF EXISTS 'boat';

CREATE TABLE 'boat' (
    'id' bigint(20) NOT NULL AUTO_INCREMENT,
    'name' varchar(255) NOT NULL,
    'type' varchar(255) NOT NULL,
    'length' decimal(19,4) NOT NULL,
    'engine_number' varchar(255) NOT NULL,
    'engine_power' decimal(19,4) NOT NULL,
    'max_speed' decimal(19,4) NOT NULL,
    'address' varchar(255) NOT NULL,
    'promotional_description' varchar(255) NOT NULL,
    'capacity' bigint(20) NOT NULL,
    'rules_of_conduct' varchar(255) NOT NULL,
    'finishing_equipment' varchar(255) NOT NULL,
    PRIMARY KEY('id')
)

DROP TABLE IF EXISTS 'boat_appointment';

CREATE TABLE 'boat_appointment' (
    'id' bigint(20) NOT NULL AUTO_INCREMENT,
    'date' datetime NOT NULL,
    'is_action' bit(1) NOT NULL,
    'duration' bigint(20) NOT NULL,
    'max_persons' bigint(20) NOT NULL,
    'price' decimal(19,4) NOT NULL,
    PRIMARY KEY('id'),
    FOREIGN KEY('boat_id') REFERENCES boat('id')
)

DROP TABLE IF EXISTS 'house';

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

DROP TABLE IF EXISTS 'navigation';

CREATE TABLE 'navigation' (
    'id' bigint(20) NOT NULL AUTO_INCREMENT
    'name' varchar(255) NOT NULL
    'boat_id' bigint(20) NOT NULL
    PRIMARY KEY ('id')
    FOREIGN KEY (boat_id) REFERENCES boat('id')
)

DROP TABLE IF EXISTS 'room';

CREATE TABLE 'room' (
    'id' bigint(20) NOT NULL AUTO_INCREMENT
    'room_number' varchar(20) NOT NULL
    'number_of_beds' bigint(20) NOT NULL
    'house_id' bigint(20) NOT NULL
    PRIMARY KEY ('id')
    FOREIGN KEY (house_id) REFERENCES house('id')
)