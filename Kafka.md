# Kafka
- Asyncronous communication between services
- We don't need to wait for the responce while communicating between services.
- Good for Post, Put, Patch, Delete operations
## pom.xml
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka</artifactId>
    </dependency>
## Producer (sends)
1. create event (dto to send to other service)
2. Autowire KafkaTemplate
3. kafkaTemplate.send("notificationTopic", notification(order));
## Properties
spring:
  kafka:
    bootstrap-servers: localhost:9092 # kafka host
    template:
      default-topic: notificationTopic # topic name
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
      properties:
        spring.json.type.mapping: event:com.maksym.orderservice.event.NotificationEvent # tag:class to send
## Consumer (retreives)
1. Create listener with argument as evenObject to retreive
@KafkaListener(topics = "notificationTopic")
    public void handleNotification(NotificationEvent notificationEvent){
        
    }
## Properties
spring:
  kafka:
    bootstrap-servers: localhost:9092 # kafka host
    template:
      default-topic: notificationTopic #topic name
    consumer:
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      group-id: notificationId # group id for the consumer
    properties:
      spring.json.type.mapping: event:com.maksym.notificationservice.event.NotificationEvent #  tag:class to retreive
#Docker compose
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.0.1
    container_name: zookeeper
    ports:
      - "2181:2181"
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
      
  broker:
    image: confluentinc/cp-kafka:7.0.1
    container_name: broker
    ports:
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1