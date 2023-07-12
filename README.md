# departmentmicroservices-webclient
Each Eureka server acts as a client also.

Each service will have its own database

####service registry
- how many instances and which services are there in the entire architecture
- it handles load balancing 
- Netflix OSS
- Eureka server dependency
- @EnableEurekaServer
- Each Eureka server acts as a client also. To stop it doing so add client.register-with-eureka: false in configuration(properties/yaml)            
####API Gateway
- all requests are gone through API gateway to its destination
- even between services to services also
- can add security here
- gateway dependency ,actuator, config client, zipkin client, eureka discovery client dependencies
- spring.cloud.gateway.routes: to define service url's
- from the port of api gatweay we can connect to all other services running on different ports using application names and endpoints

####Config Server
- all configurations will be placed in here
- config server dependency
- @EnableConfigServer

####Zipkin
-distributed log tracing
- gives logs of all requests and entire trace of log
- uses micrometer observability
- localhost:9411

####department service & Employee service common
- Eureka discovery client dependency - to tell this service has to be discovered by eureka server
- @EnableDiscoveryClient
- Give eureka service URL in configuration(properties/yaml) to tell connect to this eureka client
- config client dependency
- config.import:httpportofconfigserver- to fetch configurations from config server
- Zipkin observability dependency- adds 2 dependencies 
- spring actuator
- management.tracing.probability- 1 to publish everything to Zipkin

####department service 
- create web client here because we are fetching data from employee service
- if employee service wants to fetch from department Service need to have another web client there also
- spring reactive web dependency gives spring-starter-webflux for webclient
- create bean of webclient in config package
- give base url with service name
- since this is connected to service registry we have load balancer there so we need to include load balancer filter here
  
