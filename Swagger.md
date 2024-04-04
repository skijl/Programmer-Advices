# Sewagger
> Documentation your APIs for the frontend developer easier usage
> Default uri: `http://localhost:8080/swagger-ui/index.html`
### pom.xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
### Annotations
- **On Controller:**
    - `@Tag(name = "Order Controller", description = "Operations related to Order")`
- **On methods:**
    - `@Operation(summary = "Create an order", description = "Create new order")`
    - `@ApiResponse(responseCode = "201", description = "Order saved successfully")`
