# Elastic Search
- Elasticsearch is a distributed, RESTful search and analytics engine capable of addressing a growing number of use cases. 
- As the heart of the Elastic Stack, it centrally stores your data for lightning fast search, fine‑tuned relevancy, and powerful analytics that scale with ease.
- More info: https://geshan.com.np/blog/2023/06/elasticsearch-docker/
## Docker-Compose
elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.13.0
    container_name: elasticsearch
    environment:
      - "discovery.type=single-node"
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m" # optional
      - "xpack.security.enabled=false"
    ports:
      - "9200:9200"
      - "9300:9300"
## pom.xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
    </dependency>
## Use
- http://localhost:9200
- create index: PUT /<index_name>
- insert value in index: POST /<index_name>/_doc + {json_body}
- get all values in index: POST /<index_name>/_search
## application.yml
spring:
  elasticsearch:
    uris: http://localhost:9200
