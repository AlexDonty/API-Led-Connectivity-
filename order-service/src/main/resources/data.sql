 create table orders (
        uuid varchar(255) not null,
        customer_uuid varchar(255),
        product varchar(255),
        quantity float(53),
        primary key (uuid)
    );

    INSERT INTO orders (uuid, customer_uuid, product, quantity)
    VALUES ('a3f1c9f2-1d3b-4e2a-9f1a-000000000001','a3f1c9f2-1d3b-4e2a-9f1b-000000000001', 'producto 1', 10.00);
    INSERT INTO orders (uuid, customer_uuid, product, quantity)
    VALUES ('a3f1c9f2-1d3b-4e2a-9f1a-000000000002','a3f1c9f2-1d3b-4e2a-9f1b-000000000002', 'producto 2', 20.50);
    INSERT INTO orders (uuid, customer_uuid, product ,quantity)
    VALUES ('a3f1c9f2-1d3b-4e2a-9f1a-000000000003','a3f1c9f2-1d3b-4e2a-9f1b-000000000003', 'producto 3', 20.50);