# Docker

## Running 

### PostGIS

#### Build 

>  docker build -t henmerlin/postgis .

#### Run 

>  docker run --name postgis -e POSTGRES_PASSWORD=postgis -d henmerlin/postgis

#### Remove

> docker rm postgis -f


### pgAdmin4

> docker run -p 8090:80 -v "/home/idtrack/pgadmin/lib/pgadmin:/var/lib/pgadmin" -e "PGADMIN_DEFAULT_EMAIL=henmerlin@gmail.com"         -e "PGADMIN_DEFAULT_PASSWORD=henmerlin"         -d dpage/pgadmin4
