# microservices-projects

### Microservices in one video by java tichie
## we used association mapping in this project
payment service </br>
order service</br>
clodu-gateway : dependancies[actuator,edureka client,gateway,hystrix ]                               </br>
service-registry              </br>
hystrix-dashboard       </br>
config-server            </br>

Rest call in order service


#### application.yml in order-service

```
eureka:
 client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
     defaultZone: http://localhost:8761/eureka/
     
     
     
 instance:
    hostname: localhost
```

#### application.yml in service registry
```
eureka:
 client:
    register-with-eureka: true
    fetch-registry: true
 server
     port:8761
  /*   service-url:
       defaultZone: http://localhost:8761/eureka/    */
     

```

#### application.yml in cloud-gateway
```
    
spring:
  application:
    name: GATEWAY-SERVICE
    
eureka:
  instance:
    hostname: localhost
    
    
  cloud:
    gateway:
      routes:
      - id: order-service
        uri: lb://ORDER-SERVICE
        predicates:
        - Path=/order/**
        filters:
        - name: CircuitBreaker
          args:
            name: order-service
            fallbackuri: forward:/orderFallBack
    

hystrix:
  command:
    fallbackcmd:
      execution:
        isolation:
          thread:
            timeoutInMillieseconds: 5000


management:
  endpoints:
    web:
      exposure:
        include: hystrix.stream
        

   
   
        
        
# if request is not sending any response , then after five second it redirect  
   ```
   
   ### developed by Rushikesh
