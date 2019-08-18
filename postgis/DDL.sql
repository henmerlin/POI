-- DATABASE
CREATE DATABASE poi
  WITH ENCODING='UTF8'
       OWNER=postgres
       CONNECTION LIMIT=-1;

\c poi;

CREATE SCHEMA domain AUTHORIZATION postgres;

CREATE EXTENSION postgis;
CREATE EXTENSION fuzzystrmatch;
CREATE EXTENSION postgis_tiger_geocoder;



-- TABLES 

--- POI
CREATE TABLE domain.poi
(
    id serial,
    name character varying(300),
    radius_meters double precision,
    longitude double precision,
    latitude double precision,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE domain.poi
    OWNER to postgres;


--- ASSET
-- DROP TABLE domain.asset;

CREATE TABLE domain.asset
(
    id serial NOT NULL,
    asset_key character varying(200) NOT NULL,
    description character varying(300),
    CONSTRAINT asset_pkey PRIMARY KEY (id),
    CONSTRAINT asset_key_unique_key UNIQUE (asset_key)
        INCLUDE(asset_key)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-- Posições
CREATE TABLE domain.asset_position
(
    id serial NOT NULL,
    position_date timestamp without time zone,
    asset_key character varying(200) NOT NULL,
    longitude double precision,
    latitude double precision,
    ignition boolean, 
    speed double precision,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE domain.asset
    OWNER to postgres;