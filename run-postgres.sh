#!/bin/bash

#docker run --name bd-svn -p 5432:5432 -e POSTGRES_PASSWORD=123 -e POSTGRES_USER=alana -e POSTGRES_DB=svn -d postgres:11-alpine
docker run -it --rm --name bd-svn -p 5432:5432 -e POSTGRES_PASSWORD=123 -e POSTGRES_USER=alana -e POSTGRES_DB=svn postgres:11-alpine


# TODO: configurar volume para manter as informacoes ...
# https://hub.docker.com/_/postgres
# no tópico PGDATA
# This optional variable can be used to define another location - like a subdirectory - for the database files. The default is /var/lib/postgresql/data. If the data volume you're using is a filesystem mountpoint (like with GCE persistent disks) or remote folder that cannot be chowned to the postgres user (like some NFS mounts), Postgres initdb recommends a subdirectory be created to contain the data.
#For example:
#$ docker run -d \
#    --name some-postgres \
#    -e POSTGRES_PASSWORD=mysecretpassword \
#    -e PGDATA=/var/lib/postgresql/data/pgdata \
#    -v /custom/mount:/var/lib/postgresql/data \
#    postgres