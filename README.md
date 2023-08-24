# cnj-openapi-backend-spring

Cloud native Java backend based on Spring Boot using Spring Docs to document REST APIs with OpenAPI.

## Status

![Build status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoibHZGSUlTYXdoeVNGMnRnTTdFYitENWI2TW9WMXdhZURZa2N1ZExTT1FNZERQdmR3eDVocUluL3JWWjBldFdYYmNEWVJnNjN2SFlkemJVQWxac1orU3JnPSIsIml2UGFyYW1ldGVyU3BlYyI6ImhHVlZmVXQ4UGNTWHRpTFoiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-openapi-backend-spring`

### Static vs. generated OpenAPI files

In this showcase, [Springdoc](https://springdoc.org/#Introduction) is used to demonstrate the `Code First` approach
of documenting REST API according to the OpenAPI standard: the actual OpenAPI specification file is generated from
annotated application code. The generated OpenAPI specification file is served by Springdoc via `/v3/api-docs` in JSON format
and via `/v3/api-doc.yaml` in YAML format.

A Swagger UI for the exposed REST API is available as well via `/swagger-ui/index.html`.

## HOW-TO build this application locally

If all prerequisites are met, just run the following Maven command in the project folder:

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing the showcase application.

## HOW-TO start and stop this showcase locally

In order to run the whole showcase locally, just run the following docker commands in the project folder:

```shell 
docker compose up -d
docker compose logs -f 
```

Press `Ctlr+c` to stop tailing the container logs and run the following docker command to stop the showcase:

```shell 
docker compose down
```

## HOW-TO demo this showcase

The showcase application will be accessible:
* locally via `http://localhost:38080`
* remotely via `https://train2023-dev.k8s.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-openapi-backend-spring` (if the training cluster is up and running)

The OpenAPI specification of the exposed REST API is available at URI `/v3/api-docs`.
A Swagger UI of the exposed REST API is available at URI `/swagger-ui/index.html`.