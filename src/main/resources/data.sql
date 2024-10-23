insert into users(id, name, phone_number, password)
values(1001, 'om', '9818776961', 'candoit');

insert into users(id, name, phone_number, password)
values(1002, 'sumina', '9818776961', 'candoit');

insert into users(id, name, phone_number, password)
values(1003, 'fangarla', '9818776961', 'candoit');

insert into farm(id, labour, fertilizer, pesticides, seeds, users_id)
values(10001, 500.00, 1000.50, 1000.00, 400.00, 1001);

insert into farm(id, labour, fertilizer, pesticides, seeds, users_id)
values(10004, 400.00, 200.50, 100.00, 40.00, 1001);

insert into farm(id, labour, fertilizer, pesticides, seeds, users_id)
values(10002, 10000.00, 1500.50, 5000.00, 400.00, 1002);

insert into farm(id, labour, fertilizer, pesticides, seeds, users_id)
values(10003, 200.00, 1000.50, 1500.00, 600.00, 1003);