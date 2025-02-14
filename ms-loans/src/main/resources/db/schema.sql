DROP TABLE if EXISTS loan;

CREATE TABLE if NOT EXISTS `loan`
(
    loan_number int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id INT NOT NULL,
    start_dt DATE NOT NULL,
    loan_type varchar(100) NOT NULL,
    total_loan INT NOT NULL,
    amount_paid INT NOT NULL,
    outstanding_amount INT NOT NULL,
    create_dt date DEFAULT NULL
);
