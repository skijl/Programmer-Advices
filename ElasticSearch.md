# Elastic Search
- Elasticsearch is a distributed, RESTful search and analytics engine capable of addressing a growing number of use cases. 
- As the heart of the Elastic Stack, it centrally stores your data for lightning fast search, fine‑tuned relevancy, and powerful analytics that scale with ease.
- Speed and scalability
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
    uris: ${ELASTICSEARCH_URI:http://localhost:9200}
    username: ${ELASTICSEARCH_USERNAME:your_elasticsearch_username}
    password: ${ELASTICSEARCH_PASSWORD:your_elasticsearch_password}
# SpringBoot implementation
## Dto
@Document(indexName = "product")
public class ProductDto {
    @Id
    private String id;
    @Field(name = "product_id")
    private Long productId;
    @Field(name = "name")
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Field(name = "start_date")
}
## Service
public ProductDto getById(Long productId) {
        Criteria criteria = new Criteria("product_id").is(productId);
        Query query1 = new CriteriaQuery(criteria);
        NativeQuery query = new NativeQueryBuilder()
                .withSourceFilter(new FetchSourceFilterBuilder().withIncludes().build())
                .withQuery(query1)
                .build();
        SearchHits<ProductDto> searchHits = elasticsearchTemplate.search(query, ProductDto.class);
        return searchHits.stream().map(SearchHit::getContent).findFirst()
                .orElseThrow(() -> new ElasticsearchNotFoundException("Product with id: " + productId + " not found in Elasticsearch"));
    }