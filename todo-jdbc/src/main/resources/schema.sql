DROP TABLE IF EXISTS todo;
CREATE TABLE todo
(
    id          varchar(40)  not null primary key,
    description varchar(255) not null,
    created     timestamp,
    modified    timestamp,
    completed   boolean
)