# Rate Calculator #

## Overview: ##
This application is a REST API that will calculate parking rates given a specific time interval.

## Technologies and Frameworks: ##
- Java
- Jersey
- Jackson XML and JSON
- Drop Wizard Metrics (Time permitting)
- Jetty
- Gradle
- Docker (Deployment to AWS time permitting)
- Swagger Documentation

## API Documentation: ##
The rate calculator uses swagger to document it's apis. It can be found at the `<base_url>` for the servers running location. If you are running locally with gretty this browse to this location [URL](http://localhost:8080).

## Endpoints: ##
- GET /rates
- GET /rate/{startRate}/{endRate}
- POST /rate

## Tests: ##
#### Unit Tests ####
There are unit tests located inside this project. This is a slimmer set of tests than full integration from below. Unit tests can be run with the following command:
```bash
gradle test
```

#### Integration Tests ####
All integration tests can be found in the ratecalc_qe repository that has also been shared with you. Follow the instructions in the README.md to run and use these integration tests. Ideally these integration tests will be run in a CI/CD pipeline.

## How to Build: ##
#### Local Build ####
This application is using gradle and jetty. You can build this locally by running the following command:
```bash
gradle appRun
```

#### WAR file ####
This application will build a .WAR file when built that can be deployed to a tomcat server. You can build this file by running the following commands:
```bash
gradle clean build
```
```bash
gradle war
```

## Metrics: ##
Metrics are currently taken using the DropWizard Metrics library. These results are returning the default responses from the MetricsRegistry responses.

#### API ####
GET /metrics/responseTimes

## AWS Deployment: ##

## Known Issues: ##
- The application does not take into account anything but on the hour parking rates... This was bad design on my part..
should have caught this one sooner and developed the models to understand something more resilient like LocalTime for all time stamps.