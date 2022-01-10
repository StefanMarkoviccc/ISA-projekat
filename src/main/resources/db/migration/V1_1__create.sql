
CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `first_name` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `city` varchar(255) NOT NULL,
    `country` varchar(255) NOT NULL,
    `phone_number` varchar(255) NOT NULL,
    `user_type` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `registration_status` varchar(255) NOT NUll,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `boat` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `type` varchar(255) NOT NULL,
    `length` decimal(19,4) NOT NULL,
    `engine_number` varchar(255) NOT NULL,
    `engine_power` decimal(19,4) NOT NULL,
    `max_speed` decimal(19,4) NOT NULL,
    `address` varchar(255) NOT NULL,
    `promotional_description` varchar(255) NOT NULL,
    `capacity` bigint(20) NOT NULL,
    `rules_of_conduct` varchar(255) NOT NULL,
    `fishing_equipment` varchar(255) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `boat_appointment` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `date` datetime NOT NULL,
    `is_action` bit(1) NOT NULL,
    `duration` bigint(20) NOT NULL,
    `max_persons` bigint(20) NOT NULL,
    `price` decimal(19,4) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`boat_id`) REFERENCES boat(`id`)
);

CREATE TABLE IF NOT EXISTS `house`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT
    `user_id` bigint(20) NOT NULL
    `name` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `geographical_width` decimal(19,4) NOT NULL
    `geographical_length` decimal(19,4) NOT NULL
    `description` varchar(255) NOT NULL
    `rules_of_conduct` varchar(255) NOT NULL
    PRIMARY KEY (`id`)
    FOREIGN KEY (user_id) REFERENCES user(`id`)
);

CREATE TABLE IF NOT EXISTS `navigation` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT
    `name` varchar(255) NOT NULL
    `boat_id` bigint(20) NOT NULL
    PRIMARY KEY (`id`)
    FOREIGN KEY (`boat_id`) REFERENCES boat(`id`)
);

CREATE TABLE IF NOT EXISTS `room` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT
    `room_number` varchar(20) NOT NULL
    `number_of_beds` bigint(20) NOT NULL
    `house_id` bigint(20) NOT NULL
    PRIMARY KEY (`id`)
    FOREIGN KEY (`house_id`) REFERENCES house(`id`)
);

CREATE TABLE IF NOT EXISTS `price_list`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `serviceName` varchar(255),
    `house_id` bigint(20) NOT NULL,
    `price` decimal(19,4) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`house_id`) REFERENCES house(`id`)
);

CREATE TABLE IF NOT EXISTS `appointment`(
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
    FOREIGN KEY(`room_id`) REFERENCES room(`id`)
);

CREATE TABLE IF NOT EXISTS `adventure`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `biography` varchar(255) NOT NULL,
    `max_number_of_people` bigint(20) NOT NULL,
    `adventure_appointment` datetime NOT NULL,
    `rules` varchar(255) NOT NULL,
    `fishing_equipment` varchar(255) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `adventure_price` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) NOT NULL,
    `price` decimal(19,4) NOT NULL,
    `description` varchar(255) NOT NULL,
    PRIMARY KEY(`id`)
    FOREIGN KEY(`adventure_id` REFERENCES adventure(`id`)
);

CREATE TABLE IF NOT EXISTS `adventure_reservation` (
    `id` bigint(20) NOT NULL,
    `date_and_time` datetime NOT NULL,
    `place` varchar(255) NOT NULL,
    `duration` bigint(20) NOT NULL,
    `maximum_number_of_persons` varchar(255) NOT NULL,
    `additional_services` varchar(255) NOT NULL,
    `price` decimal(19,4) NOT NULL,
    PRIMARY KEY(`id`)
);

insert into `user` (`id`, `email`, `password`, `first_name`, `last_name`, `address`, `city`, `country`, `phone_number`, `user_type`, `description`, `registration_status`, `deleted`) values(1, 'Stefan@gmail.com', '$2a$12$6ACorI9jZYYh/f6014L9u.nKqKcvnH6GX7P89aiM87yGMPWarY4f6', 'Stefan', 'Markovic', 'Danila Kisa 44', 'Novi Sad', 'Srbija', '0643580000', 'CLIENT', 'steks', 'APPROVED', 0);
insert into `user` (`id`, `email`, `password`, `first_name`, `last_name`, `address`, `city`, `country`, `phone_number`, `user_type`, `description`, `registration_status`, `deleted`) values(2, 'Bojana@gmail.com', '$2a$12$6ACorI9jZYYh/f6014L9u.nKqKcvnH6GX7P89aiM87yGMPWarY4f6', 'Bojana', 'Lukic', 'Veselina Maslese 44', 'Novi Sad', 'Srbija', '065555555', 'HOUSE_OWNER', 'bojana mali luk', 'APPROVED', 0);
insert into `user` (`id`, `email`, `password`, `first_name`, `last_name`, `address`, `city`, `country`, `phone_number`, `user_type`, `description`, `registration_status`, `deleted`) values(3, 'Viki@gmail.com', '$2a$12$6ACorI9jZYYh/f6014L9u.nKqKcvnH6GX7P89aiM87yGMPWarY4f6', 'Violeta', 'Kukic', 'Zitni trg 11', 'Novi Sad', 'Srbija', '0633333333', 'FISHING_INSTRUCTOR', 'kuki test', 'APPROVED', 0);

insert into `boat` (`id`, `name`, `type`, `length`, `engine_number`, `engine_power`, `max_speed`, `address`, `promotional_description`, `capacity`, `rules_of_conduct`, `fishing_equipment`, `deleted`) values (1,'Maximus', 'SeaDOO', '5', '2', '200', '300', 'Danila Kisa 23', 'opisopisopis', '5', 'nesto', 'YES', 0);
insert into `boat` (`id`, `name`, `type`, `length`, `engine_number`, `engine_power`, `max_speed`, `address`, `promotional_description`, `capacity`, `rules_of_conduct`, `fishing_equipment`, `deleted`) values (2,'Koleos', 'Yamaha', '12', '4', '200', '200', 'Milosa Parovica 36', 'opis', '12', 'nestoo', 'NO', 0);

insert into `house` (`id`, `user_id`, `name`, `address`, `geographical_width`, `geographical_length`, `description`, `rules_of_conduct`, `availability_period`, `average`, `deleted`) values (1,2, 'Bojana', 'Veselina Maslese', '1234', '4321', 'Opis kuce', 'Nema pusenja', 'sve zauzeto', '5', 0);


insert into `adventure` (`id`, `name`, `address`, `description`, `biography`, `max_number_of_people`, `adventure_appointment`, `rules`, `fishing_equipment`,`price`,`deleted`) values (1,'Tara', 'Bulevar Patrijarha Pavla 30', 'Rafting', 'Many years of experience with the river, people ..', 'For one round 15.', '21.05.2022.-26.05.2022.', 'Obedience, devotion.', 'Diving equipment', '120', 0);