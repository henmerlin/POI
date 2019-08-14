# Inicio

## Docker

### Running 

#### PostGIS

```docker run --name postgis -e POSTGRES_PASSWORD=postgis -d mdillon/postgis```


#### pgAdmig

```docker run -p 8090:80         -e "PGADMIN_DEFAULT_EMAIL=henmerlin@gmail.com"         -e "PGADMIN_DEFAULT_PASSWORD=henmerlin"         -d dpage/pgadmin4```