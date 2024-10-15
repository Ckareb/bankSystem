## Установка и запуск

### 1. Клонирование репозитория

Сначала клонируйте репозиторий на ваш компьютер:

git clone https://github.com/yourusername/bankSystem.git
`cd bankSystem`

### Восстановление базы данных из контейнера Docker
Сначала запустите контейнер с помощью этой команды в корневой папке src `docker-compose up -d`
Затем восстановите БД с помощью этой команды в том же каталоге:
`docker exec -i my_postgres_db sh -c "pg_restore -U username -d banksystem" < db_dump_one.tar`