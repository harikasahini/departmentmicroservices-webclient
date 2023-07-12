# departmentmicroservices-webclient
Each Eureka server acts as a client also.

Each service will have its own database

service registry- how many instances and which services are there in the entire architecture
                - it handles load balancing 
                - Netflix OSS

API Gateway- all requests are gone through API gateway to its destination
           - even between services to services also
           - can add security here
           
Config Server- all configurations will be placed in here

Zipkin- distributed log tracing
      - gives logs of all requests and entire trace of log
      - uses micrometer observability
