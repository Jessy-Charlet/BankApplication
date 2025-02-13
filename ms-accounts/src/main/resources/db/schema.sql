DROP TABLE if EXISTS customer;
DROP TABLE if EXISTS account;

CREATE TABLE if NOT EXISTS `customer`
(
    customer_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    mobile_number varchar(100) NOT NULL,
    create_dt date DEFAULT NULL
);
    
CREATE TABLE if NOT EXISTS `account`
(
    customer_id int NOT NULL,
    account_number bigint PRIMARY KEY,
    account_type varchar(100) NOT NULL,
    branch_address varchar(200) NOT NULL,
    create_dt date DEFAULT NULL
)