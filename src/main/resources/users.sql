CREATE TABLE users
(
  id serial NOT NULL,
  firstname varchar,
  surname varchar,
  age integer,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;

insert into users (firstname, surname, age) values ('Ringo','Star',65);
insert into users (firstname, surname, age) values ('Alan','Parsons',35);
insert into users (firstname, surname, age) values ('Bob','Marley',20);
insert into users (firstname, surname, age) values ('Jhon','Cale',40);
insert into users (firstname, surname, age) values ('Bob','Dylan',25);
insert into users (firstname, surname, age) values ('Bob','Pollard',59);

CREATE USER mlab WITH PASSWORD '1324';
GRANT ALL PRIVILEGES ON TABLE users TO mlab;

