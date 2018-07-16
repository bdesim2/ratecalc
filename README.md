# Rate Calculator #

## Overview: ##
This application is a REST API that will calculate parking rates given a specific time interval.

## Technologies and Frameworks: ##
- Java
- Jersey
- Jackson XML and JSON
- Drop Wizard Metrics
- Jetty
- Gradle
- Docker
- Swagger Documentation

## API Documentation: ##
The rate calculator uses swagger to document it's apis. It can be found at the `<base_url>` for the servers running location.

## Endpoints: ##
- GET /rates
- GET /rate/{startRate}/{endRate}
- POST /rate

## Metrics: ##


## How to Build: ##
#### Local Build ####
This application is using gradle and jetty. You can build this locally bu running the following command:
```bash

```

## AWS Deployment: ##