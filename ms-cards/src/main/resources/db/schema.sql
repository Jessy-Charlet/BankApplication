DROP TABLE if EXISTS card;

CREATE TABLE if NOT EXISTS `card`
(
    card_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id int NOT NULL,
    card_number varchar(100) NOT NULL,
    card_type varchar(100) NOT NULL,
    total_limit int NOT NULL,
    amount_used int NOT NULL,
    available_amount int NOT NULL,
    create_dt date DEFAULT NULL
);
