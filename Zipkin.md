## Description
- Distributed tracing system needed to troubleshoot latency problems in service architectures.
- Features include both the collection and lookup of this data.
## Properties
//default is on port 9411
  zipkin:
    tracing:
      endpoint: 
## pom.xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.reporter2</groupId>
            <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>
        <!-- if openfeign is present -->
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-micrometer</artifactId>
            <version>13.2.1</version>
        </dependency>
## Docker compose
services:
  storage:
    image: openzipkin/zipkin-mysql
    container_name: zipkin-mysql
    environment:
      MYSQL_ROOT_PASSWORD: your_password
      MYSQL_DATABASE: zipkin
    volumes:
      - mysql_data:/var/lib/mysql

  zipkin:
    image: openzipkin/zipkin
    container_name: zipkin
    environment:
      - STORAGE_TYPE=mysql
      - MYSQL_HOST=storage
      - MYSQL_USER=zipkin
      - MYSQL_PASS=zipkin
    ports:
      - "9411:9411"
    depends_on:
      - storage
    healthcheck:
      test: [ "CMD", "curl", "-f", "http://localhost:9411/health" ]

  dependencies:
    image: openzipkin/zipkin-dependencies
    container_name: zipkin-dependencies
    entrypoint: crond -f
    environment:
      - STORAGE_TYPE=mysql
      - MYSQL_HOST=storage
      - MYSQL_USER=zipkin
      - MYSQL_PASS=zipkin
    depends_on:
      - storage