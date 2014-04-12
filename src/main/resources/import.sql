insert into categories(id, name, version) values (1, 'Books', 0);
insert into categories(id, name, version) values (2, 'Home', 0);
insert into categories(id, name, version) values (3, 'Garden', 0);


insert into products(id, name, description, category_id, unit_price, version) values(1, 'Star Wars Volume 1', 'Star Wars - Volume 1', 1, 20.5, 0);
insert into products(id, name, description, category_id, unit_price, version) values(2, 'Star Wars Volume 2', 'Star Wars - Volume 2', 1, 20.5, 0);
insert into products(id, name, description, category_id, unit_price, version) values(3, 'Game of Thrones', 'Game of Thrones Omnibook', 1, 40.67, 0);

insert into products(id, name, description, category_id, unit_price, version) values(4, 'Wall Clock', 'Ultimate Wall Clock', 2, 10.99, 0);
insert into products(id, name, description, category_id, unit_price, version) values(5, 'Area Rugs', 'Area Rugs', 2, 100.29, 0);
insert into products(id, name, description, category_id, unit_price, version) values(6, 'Book Case', 'Book Case', 2, 30.67, 0);

insert into products(id, name, description, category_id, unit_price, version) values(7, 'Shovel', 'Shovel', 3, 20.00, 0);
insert into products(id, name, description, category_id, unit_price, version) values(8, 'Lopper', 'Lopper', 3, 30.00, 0);
insert into products(id, name, description, category_id, unit_price, version) values(9, 'Lawn Mower', 'Lawn Mower', 3, 199.99, 0);

insert into inventory(id, product_id, quantity, version) values(1, 1, 100, 0);
insert into inventory(id, product_id, quantity, version) values(2, 2, 100, 0);
insert into inventory(id, product_id, quantity, version) values(3, 3, 0, 0);
insert into inventory(id, product_id, quantity, version) values(4, 4, 25, 0);
insert into inventory(id, product_id, quantity, version) values(5, 5, 25, 0);
insert into inventory(id, product_id, quantity, version) values(6, 6, 24, 0);
insert into inventory(id, product_id, quantity, version) values(7, 7, 30, 0);
insert into inventory(id, product_id, quantity, version) values(8, 8, 41, 0);
insert into inventory(id, product_id, quantity, version) values(9, 9, 3, 0);