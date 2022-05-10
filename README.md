# microservices-projects

### Microservices in one video by java tichie
payment service </br>
order service</br>
clodu-gateway,service-registry,hystrix-dashboard,config-server


#### application.yml in cloud-gateway
```
    
spring:
  application:
    name: GATEWAY-SERVICE
    
    
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
        

    
    ```
   
        
        
# if request is not sending any response , then after five second it redirect  
   
   
   
