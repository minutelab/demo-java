CREATE TABLE people
(
  id serial NOT NULL,
  firstname varchar,
  surname varchar,
  age integer,
  CONSTRAINT people_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE people
  OWNER TO postgres;

insert into people (firstname, surname, age) values ('jo','Scott',65);
insert into people (firstname, surname, age) values ('mo','lam',40);
insert into people (firstname, surname, age) values ('bo','shmo',35);

CREATE USER mlab WITH PASSWORD '1324';
GRANT ALL PRIVILEGES ON TABLE people TO mlab;

