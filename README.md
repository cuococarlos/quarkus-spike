


# Getting started

### Start local server

```bash
 ./mvnw compile quarkus:dev
 ```
The server should be running at http://localhost:8080


### Running the application tests

``` 
./mvnw test 
```

### Running postman collection tests

```
./collections/run-api-tests.sh
```

### Building jar file

```
./mvnw package
```

### Building native executable

GraalVM is necessary for building native executable, more information about
setting up GraalVM can be found in [Quarkus guides](https://quarkus.io/guides/)
and database engine need to be changed.

```
./mvnw package -Pnative
```

