CREATE ROLE quarkus WITH LOGIN PASSWORD 'quarkus';
CREATE DATABASE elytron_security_jdbc;
GRANT ALL PRIVILEGES ON DATABASE elytron_security_jdbc TO quarkus;
\c elytron_security_jdbc

CREATE TABLE test_user (
    id INT,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255),
    position VARCHAR(255),
    entity VARCHAR(255),
    town VARCHAR(255)
); 
GRANT ALL PRIVILEGES ON TABLE  test_user TO quarkus;
CREATE SEQUENCE hibernate_sequence START 1;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO quarkus;