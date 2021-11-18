DROP TABLE IF EXISTS 'user';

CREATE TABLE 'user' (

)

CREATE TABLE 'appointment'(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `house_id` bigint(20) NOT NULL,
    `room_id` bigint(20) NOT NULL,
    `appointment_date` datetime NOT NULL,
    `is_action` bit(1) NOT NULL,
    `duration` bigint(20) NOT NULL,
    `maxPersons` bigint(20) NOT NULL,
    `price` decimal(19,4) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`house_id`) REFERENCES house(`id`),
    FOREIGN KEY(`room_id`) REFERENCES room(`id`),
);

CREATE TABLE 'price_list'(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `serviceName` varchar(255),
    `house_id` bigint(20) NOT NULL,
    `price` decimal(19,4) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`house_id`) REFERENCES house(`id`),

);