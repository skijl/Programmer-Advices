# CircuitBreaker
- 3 States: CLOSED, OPEN, HALF_OPEN
- You specify treshhold and after its exeeding state is OPEN and access to the server closes and you can specify handling for such a situation
## application.yml
```
resilience4j:
  circuitbreaker:
    instances:
      companyBreaker:
        register-health-indicator: true
        registerHealthIndicator: true
        sliding-window-size: 10
        minimum-number-of-calls: 5
        permitted-number-of-calls-in-half-open-state: 3
        wait-duration-in-open-state:
          seconds: 10
        failure-rate-threshold: 50
        allow-health-indicator-to-fail: true
        automatic-transition-from-open-to-half-open-enabled: true
        sliding-window-type: count_based
```
## Retry
- Retry some amount of times if the response is negative 
## Rate Limiter
- Technique for limiting network traffic
- Prevent abuse
- Resourse allocation
- Cost management
### application.yml
```
resilience4j:
  ratelimiter:
    configs:
      companyBreaker:
        timeout-duration: 0
        limit-refresh-period:
        seconds: 5
        limit-for-period: 1
```
## pom.xml
```
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
    <version>3.1.0</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
  </dependency>
```