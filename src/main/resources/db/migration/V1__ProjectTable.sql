CREATE TABLE project(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    stack VARCHAR(500) NOT NULL,
    description VARCHAR(1000),
    link VARCHAR(1000)
);