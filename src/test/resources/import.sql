insert into categories(id, name) values (1, 'Books');

insert into products(id, name, description, category_id, unit_price) values(1, 'Dummy Book1', 'Dummy Book 1', 1, 1.0);
insert into products(id, name, description, category_id, unit_price) values(2, 'Dummy Book2', 'Dummy Book2', 1, 2.5);

insert into inventory(id, product_id, quantity) values(1, 1, 100);
insert into inventory(id, product_id, quantity) values(2, 2, 100);