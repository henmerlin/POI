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


    -- EEE MMM dd yyyy HH:mm:ss zXXX
    -- Wed Dec 12 2018 01:04:09 GMT-0200 (Hora oficial do Brasil)


-- yyyy/MM/dd HH:mm:ss

placa	data_posicao	velocidade	longitude	latitude	ignicao
TESTE001	Wed Dec 19 2018 21:38:26 GMT-0200 (Hora oficial do Brasil)	78	-50.5	-25.5	Y
TESTE001	Wed Dec 19 2018 21:38:41 GMT-0200 (Hora oficial do Brasil)	78	-50.5	-25.5	Y
TESTE001	Wed Dec 19 2018 21:40:41 GMT-0200 (Hora oficial do Brasil)	66	-50.4	-25.5	Y
TESTE001	Wed Dec 19 2018 21:42:41 GMT-0200 (Hora oficial do Brasil)	31	-50.4	-25.5	Y
TESTE001	Wed Dec 19 2018 21:43:58 GMT-0200 (Hora oficial do Brasil)	87	-50.4	-25.5	Y
TESTE001	Wed Dec 19 2018 21:45:55 GMT-0200 (Hora oficial do Brasil)	35	-50.4	-25.5	Y
TESTE001	Wed Dec 19 2018 21:47:37 GMT-0200 (Hora oficial do Brasil)	48	-50.4	-25.5	Y
TESTE001	Wed Dec 19 2018 21:49:36 GMT-0200 (Hora oficial do Brasil)	73	-50.3	-25.5	Y
TESTE001	Wed Dec 19 2018 21:50:43 GMT-0200 (Hora oficial do Brasil)	73	-50.3	-25.5	Y
TESTE001	Wed Dec 19 2018 21:50:58 GMT-0200 (Hora oficial do Brasil)	60	-50.3	-25.5	Y
TESTE001	Wed Dec 19 2018 21:51:15 GMT-0200 (Hora oficial do Brasil)	66	-50.3	-25.5	Y
TESTE001	Wed Dec 19 2018 21:51:31 GMT-0200 (Hora oficial do Brasil)	73	-50.3	-25.5	Y
TESTE001	Wed Dec 19 2018 21:52:29 GMT-0200 (Hora oficial do Brasil)	105	-50.3	-25.5	Y
TESTE001	Wed Dec 19 2018 21:52:47 GMT-0200 (Hora oficial do Brasil)	97	-50.3	-25.5	Y
