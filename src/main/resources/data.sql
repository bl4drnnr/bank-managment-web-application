INSERT INTO person_client(first_name, last_name, pesel, address, home_phone, work_phone) VALUES ('Jan', 'Kowalski', '1234567890', 'Wrszawskiego 30', '+123123', '+321321');
INSERT INTO person_client(first_name, last_name, pesel, address, home_phone, work_phone) VALUES ('Anna', 'Kochanska', '0987654321', 'Dabrowskiego 2/8a', null, null);
INSERT INTO person_client(first_name, last_name, pesel, address, home_phone, work_phone) VALUES ('Joe', 'Doe', '567765321', 'Sucharskiego 15', null, '+123321');
INSERT INTO person_client(first_name, last_name, pesel, address, home_phone, work_phone) VALUES ('Artur', 'Nowak', '567765321', 'Sucharskiego 15', '+090909', null);

INSERT INTO company_client(nip, company_name, company_address, company_phone) VALUES ('6565656', 'IT.net', 'Sloneczna 2', '+000999111');
INSERT INTO company_client(nip, company_name, company_address, company_phone) VALUES ('3214235', 'Deloitte', 'Rejtana 412', '+98877665');
INSERT INTO company_client(nip, company_name, company_address, company_phone) VALUES ('3456223', 'TopSoftware', 'Zeromskiego 4', '+456745323');

INSERT INTO debit_account(amount_of_money, pcid, ссid) VALUES (3000, 1, null);
INSERT INTO debit_account(amount_of_money, pcid, ссid) VALUES (15000, null, 3);
INSERT INTO debit_account(amount_of_money, pcid, ссid) VALUES (12000, null, 3);

INSERT INTO credit_account(amount_of_money, expired_at, pcid, ссid) VALUES (12000, '2018-07-22', 1, null);
INSERT INTO credit_account(amount_of_money, expired_at, pcid, ссid) VALUES (10000, '2018-03-05', 1, null);
INSERT INTO credit_account(amount_of_money, expired_at, pcid, ссid) VALUES (23000, '2020-12-12', null, 3);