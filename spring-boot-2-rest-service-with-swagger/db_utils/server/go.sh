set -x
docker run --rm --network=host -v /tmpfs/mysqld/:/var/run/mysqld/ -v $(pwd)/conf:/etc/mysql/conf.d --name mysql_server -e MYSQL_ROOT_PASSWORD=test  mysql:latest
