INSERT INTO medicine (
        id, name, company_name, price, uses, expiration_date
    ) 
    VALUES (1, 'Simvastatina', 'Company1', 5.55, 6, '2023-12-31');
INSERT INTO medicine (
        id, name, company_name, price, uses, expiration_date
    ) 
    VALUES (2, 'Aspirina', 'Company2', 1.23, 12, '2024-12-31');
INSERT INTO medicine (
        id, name, company_name, price, uses, expiration_date
    ) 
    VALUES (3, 'Omeprazol', 'Company3', 7.55, 7, '2025-12-31');
INSERT INTO medicine (
        id, name, company_name, price, uses, expiration_date
    ) 
    VALUES (4, 'Lexotiroxina sódica', 'Company4', 6.55, 8, '2026-12-31');


--Employee things, not necessary for this assignment but useful for test
INSERT INTO employee (id, name, last_name, badge_number) 
    VALUES (1, 'Vladimir', 'Cuevas', 12345);
INSERT INTO employee (id, name, last_name, badge_number) 
    VALUES (2, 'Enrique', 'Saavedra', 12346);
INSERT INTO employee (id, name, last_name, badge_number) 
    VALUES (3, 'Fulanito', 'Campos', 12347);
INSERT INTO employee (id, name, last_name, badge_number) 
    VALUES (4, 'Daniel', 'Vergara', 12348);

--USERS

insert into user
(active, address, dob, email, first_name, last_name, password, phone_number, roles, user_name)
values
(
   1, 'ST50, Blvd, Panama', DATE '1981-09-17', 'user@Domain.com', 'Administrator', 'Last Name', 'pass', '555-5555' ,'ADMIN', 'admin'
);

insert into user
(active, address, dob, email, first_name, last_name, password, phone_number, roles, user_name)
values
(
   1, 'ST50, Blvd, Panama', DATE '1981-09-17', 'user@Domain.com', 'Administrator', 'Last Name', 'pass', '555-5555' ,'USER', 'user'
);