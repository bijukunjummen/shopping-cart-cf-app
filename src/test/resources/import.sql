insert into categories(id, name, version) values (1, 'Books', 0);

insert into products(id, name, description, category_id, unit_price, version) values(1, 'Dummy Book1', 'Dummy Book 1', 1, 1.0, 0);
insert into products(id, name, description, category_id, unit_price, version) values(2, 'Dummy Book2', 'Dummy Book2', 1, 2.5, 0);

insert into inventory(id, product_id, quantity, version) values(1, 1, 100, 0);
insert into inventory(id, product_id, quantity, version) values(2, 2, 100, 0);