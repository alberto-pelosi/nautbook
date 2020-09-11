CREATE TABLE INGREDIENT
(
id bigserial constraint ingredient_pk primary key,
name varchar (255) not null,
description varchar (255)
);

create unique index ingredient_unindex on INGREDIENT (name);

CREATE TABLE RECIPE
(
id bigserial constraint recipe_pk primary key,
name varchar (255) not null,
description varchar (255)
);

create unique index recipe_unindex on RECIPE (name);

CREATE TABLE RECIPE_INGREDIENT
(
id bigserial constraint recipe_ingredient_pk primary key,
recipe_id bigint not null,
ingredient_id bigint not null,
quantity double precision not null,
unit_of_measure varchar (10)
);

create unique index recipe_ingredient_unindex on RECIPE_INGREDIENT (recipe_id, ingredient_id);
