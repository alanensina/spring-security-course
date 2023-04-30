
# Spring Security Course

A simple API using Spring Boot 3 and Spring Security 6.

### Prerequisites:
- Java 17+
- Docker

### Setting up:
Before to start the application, make sure that Docker is installed and start the docker-compose file into resources of the project:

```docker compose up -d```

After that , a PostgreSQL database will be initialized.






## API

#### Register an user

```
  POST /api/v1/auth/register
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `firstName` | `String` | First name of the user |
| `lastName` | `String` | Last name of the user  |
| `email` | `String` | Email of the user used to authenticate  |
| `password` | `String` | Password of the user used to authenticate  |

##### Return the token created.

#### Authenticate the user

```
  POST /api/v1/auth/authenticate
```

| Parameter   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email` | `String` | Email of the user used to authenticate  |
| `password` | `String` | Password of the user used to authenticate  |

##### Return the token authenticated.

#### Example of endpoint secured

```
  GET /api/v1/demo
```
##### This endpoint just work if a token is passed.







## Author

- [@alanensina](https://www.github.com/alanensina)


## References

- [@amigoscode](https://github.com/amigoscode)
- [Spring Boot 3 + Spring Security 6 - JWT Authentication and Authorisation](https://www.youtube.com/watch?v=KxqlJblhzfI)
