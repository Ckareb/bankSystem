## Установка и запуск

### 1. Клонирование репозитория

Сначала клонируйте репозиторий на ваш компьютер:


git clone https://github.com/yourusername/bankSystem.git
`cd bankSystem`


### Войдите в командный код PostgreSQL и создайте новые исходные данные:

Пример кода
`psql -U yourusername CREATE DATABASE bank_db`


### Восстановление базы данных
Пример кода:
`docker exec -i my_postgres_db sh -c "pg_restore -U username -d banksystem" < db_dump.tar`