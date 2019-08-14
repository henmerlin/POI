-- DATABASE
CREATE DATABASE poi
  WITH ENCODING='UTF8'
       OWNER=postgres
       TEMPLATE=template_postgis
       CONNECTION LIMIT=-1;

-- SCHEMA
CREATE SCHEMA domain AUTHORIZATION postgres;

-- TABLES 

--- POI
CREATE TABLE domain.poi
(
    id serial,
    name character varying(300),
    "radius_meters" double precision,
    point point,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE domain.poi
    OWNER to postgres;


--- ASSET
CREATE TABLE domain.asset
(
    id serial NOT NULL,
    key character varying(200) NOT NULL,
    description character varying(300),
    PRIMARY KEY (id),
    UNIQUE (key)
        INCLUDE(key)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE domain.asset
    OWNER to postgres;