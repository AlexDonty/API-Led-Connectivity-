CREATE TABLE customer (
    uuid VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO customer (uuid, name, email) VALUES ('a3f1c9f2-1d3b-4e2a-9f1b-000000000001', 'Juan Pérez', 'juan.perez@example.com');
INSERT INTO customer (uuid, name, email) VALUES ('b4d2e0a3-2e4c-5f3b-0a2c-000000000002', 'María Gómez', 'maria.gomez@example.com');
INSERT INTO customer (uuid, name, email) VALUES ('c5e3f1b4-3f5d-6g4c-1b3d-000000000003', 'Luis Rodríguez', 'luis.rodriguez@example.com');
