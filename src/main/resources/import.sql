insert into categories(id, name) values (1, 'Books');
insert into categories(id, name) values (2, 'Home');
insert into categories(id, name) values (3, 'Garden');


insert into products(id, name, description, category_id, unit_price) values(1, 'Star Wars Volume 1', 'Star Wars - Volume 1', 1, 20.5);
insert into products(id, name, description, category_id, unit_price) values(2, 'Star Wars Volume 2', 'Star Wars - Volume 2', 1, 20.5);
insert into products(id, name, description, category_id, unit_price) values(3, 'Game of Thrones', 'Game of Thrones Omnibook', 1, 40.67);

insert into products(id, name, description, category_id, unit_price) values(4, 'Wall Clock', 'Ultimate Wall Clock', 2, 10.99);
insert into products(id, name, description, category_id, unit_price) values(5, 'Area Rugs', 'Area Rugs', 2, 100.29);
insert into products(id, name, description, category_id, unit_price) values(6, 'Book Case', 'Book Case', 2, 30.67);

insert into products(id, name, description, category_id, unit_price) values(7, 'Shovel', 'Shovel', 3, 20.00);
insert into products(id, name, description, category_id, unit_price) values(8, 'Lopper', 'Lopper', 3, 30.00);
insert into products(id, name, description, category_id, unit_price) values(9, 'Lawn Mower', 'Lawn Mower', 3, 199.99);

insert into inventory(id, product_id, quantity) values(1, 1, 100);
insert into inventory(id, product_id, quantity) values(2, 2, 100);
insert into inventory(id, product_id, quantity) values(3, 3, 0);
insert into inventory(id, product_id, quantity) values(4, 4, 25);
insert into inventory(id, product_id, quantity) values(5, 5, 25);
insert into inventory(id, product_id, quantity) values(6, 6, 24);
insert into inventory(id, product_id, quantity) values(7, 7, 30);
insert into inventory(id, product_id, quantity) values(8, 8, 41);
insert into inventory(id, product_id, quantity) values(9, 9, 3);