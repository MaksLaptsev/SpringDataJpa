## Для запуска
- Перед запуском необходимо поднять БД в докере [`docker-compose.yaml`](src/main/resources/docker-compose.yaml), либо заменить в [`application.yaml`](https://github.com/MaksLaptsev/SpringDataJpa/blob/develop/src/main/resources/application.yaml) url,username,password на свои, для существующей бд
- После запуска liquibase создаст и заполнит таблицы
- Примеры http запросов в [`requests.http`](https://github.com/MaksLaptsev/SpringDataJpa/blob/develop/src/main/resources/requests.http)