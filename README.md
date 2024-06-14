# Hello, Docker!

## Exemplo de como gerar uma imagem docker de uma aplicação Spring Boot simples.

- A imagem é gerada a partir das instruções escritas no arquivo Dockerfile


```Dockerfile
FROM maven:3.9.7-amazoncorretto-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean install

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/hello-docker-v1.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
```

### A partir deste Dockerfile é que a imagem desta aplicação é gerada.

Para gerar a imagem executamos o comando abaixo:

`docker build -t paneladev/hello-docker:v1` .

Para executar a imagem executamos o comando abaixo:

`docker run --name hello-docker -p 8080:8080 paneladev/hello-docker:v1`

Para testar se a imagem está em execução basta acessar via browser

`localhost:8080`

Para disponibilizar essa imagem é necessário enviar ao repositório de imagens do Docker, conhecido por [Docker Hub](https://hub.docker.com/explore)

`docker push paneladev/hello-docker:v1`

Para executar o comando acima é necessário ter uma conta no Docker Hub e estar logado

`docker login`