# Template for Spring-Boot based Java-Microservice
### :heavy_check_mark: Working

## Information
A prototypical java-based microservice demostrating API-first development approach, and a possible code-organization strategy. This app can serve as a base template and can be extended into a fully-functional microservice.

## Functionality
- The web-application is broken into six modules:
    1. **api** - Responsible for defining Api-specification. Current snapshot demonstrates only explicit definition of the Api-spec(i.e. no generators).
    2. **config** - Anything which is platform-related can live inside this module. For example- datasource configuration, security config, etc.
    3. **core** - This module hosts business services. It exposes its functionality via a set of business services.
    4. **api-impl** - It realizes the Api-specification using the business-services provided by the **core** module.
    5. **deployable** - This module acts as a packager and packages the web-app into a deployable artifact.
    6. **db-migration** - It is a standalone module which contains scripts for datasource migration. By default, it runs in a detached manner, to decouple app-deployment from datasource-migration.
    
## Implementation 
The application resides in spring-boot ecosystem, thus it takes advantage of spring's autoconfiguration. To be specific it uses following library/framework dependencies-
- HATEOAS
- Spring Data
- Flyway Migration

## Dependencies
- JDK 13
- Gradle
