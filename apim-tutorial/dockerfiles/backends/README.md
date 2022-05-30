## Build Monolith - All service in one Docker image

```sh
docker build -t <imageName> .
```

## Build Microservices

-   Train Schedule Service
    ```sh
    docker build -t <imageName> --build-arg SERVICE=train-schedule-info .
    ```
-   Train Service
    ```sh
    docker build -t <imageName> --build-arg SERVICE=train-service .
    ```
