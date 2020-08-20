#Микросервисы простой пример с сайта baeldung
## 1.Создаем Config Server
* Переходим на start.spring.io
  В поле artifact задать "config"
  в опциях выбрать "config server"
  скачать созданный zip файл проекта
* В main классе приложения указать аннотацию
	@EnableConfigServer
* Добавить в файл application.properties (src/main/resources) строки
	server.port=8081
	spring.application.name=config
	spring.cloud.config.server.git.uri=file://${user.home}/application-config
* Создать каталог application-config в домашнем каталоге пользователя
   перейти во вновь созданный каталог и инициализировать репозитарий
	git init
* Запустить mvn spring-boot:run	
В каждом последующем микросервисе необходимо настроить bootstrap.properties -
указать адресс сервера конфигураций. 
В начале считывается в ApplicationContext  - bootstrap.properties затем application.properties, в нем (application.properties) можно хранить свойства по умолчанию если не доступен сервер конфигурации
* Добавить зависимость в POM 
	spring-cloud-starter-netflix-eureka-client
* Изменить файл application.properties 
	eureka.client.region = default
	eureka.client.registryFetchIntervalSeconds = 5
	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/

## 2. Создаем сервер обнаружения микросервисов Eureka (реестр микросервисов)
* Переходим на start.spring.io
  В поле artifact задать "discovery"
  в опциях выбрать "eureka server", "config client"
  скачать созданный zip файл проекта
* В main классе приложения указать аннотацию
	@EnableEurekaServer
* Добавить в файл bootstrap.properties (src/main/resources) строки
	spring.cloud.config.name=discovery
	spring.cloud.config.uri=http://localhost:8081
* Добавить файл  discovery.properties в каталог application-config
	spring.application.name=discovery
	server.port=8082
	eureka.instance.hostname=localhost
	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/
	eureka.client.register-with-eureka=false
	eureka.client.fetch-registry=false
* Git commit
## 3. Создаем шлюз Gateway
* Переходим на start.spring.io
  В поле artifact задать "gateway"
  в опциях выбрать "zuul", "eureka client", "config client"
  скачать созданный zip файл проекта
* В main классе приложения указать аннотацию
	@EnableZuulProxy
	@EnableEurekaClient
* Добавить в файл bootstrap.properties (src/main/resources) строки
	spring.cloud.config.name=gateway
	spring.cloud.config.discovery.service-id=config
	spring.cloud.config.discovery.enabled=true
	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/
* Добавить файл  gateway.properties в каталог application-config
	spring.application.name=gateway
	server.port=8080
 
	eureka.client.region = default
	eureka.client.registryFetchIntervalSeconds = 5
 
	zuul.routes.flower-service.path=/flower-service/**
	zuul.routes.flower-service.sensitive-headers=Set-Cookie,Authorization
	hystrix.command.flower-service.execution.isolation.thread.timeoutInMilliseconds=600000
 
	zuul.routes.rating-service.path=/rating-service/**
	zuul.routes.rating-service.sensitive-headers=Set-Cookie,Authorization
	hystrix.command.rating-service.execution.isolation.thread.timeoutInMilliseconds=600000
 
	zuul.routes.discovery.path=/discovery/**
	zuul.routes.discovery.sensitive-headers=Set-Cookie,Authorization
	zuul.routes.discovery.url=http://localhost:8082
	hystrix.command.discovery.execution.isolation.thread.timeoutInMilliseconds=600000
* Git commit

## 4. Создаем Flower Service

* Переходим на start.spring.io
  В поле artifact задать "flower-service"
  в опциях выбрать "web", "eureka client", "config client"
  скачать созданный zip файл проекта
* В main классе приложения указать аннотацию
	@EnableEurekaClient
	@RestController
	@RequestMapping("/flowers")
см. исходники
* Добавить в файл bootstrap.properties (src/main/resources) строки
	spring.cloud.config.name=flower-service
	spring.cloud.config.discovery.service-id=config
	spring.cloud.config.discovery.enabled=true
 	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/
* Добавить файл  flower-service.properties в каталог application-config
	spring.application.name=flower-service
	server.port=8083
	eureka.client.region = default
	eureka.client.registryFetchIntervalSeconds = 5
	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/
* Git commit
* http://localhost:8080/flower-service/flowers
## 5. Создаем Rating Service
* Переходим на start.spring.io
  В поле artifact задать "rating-service"
  в опциях выбрать "web", "eureka client", "config client"
  скачать созданный zip файл проекта
* В main классе приложения указать аннотацию
	@EnableEurekaClient
	@RestController
	@RequestMapping("/ratings")
см. исходники
* Добавить в файл bootstrap.properties (src/main/resources) строки
	spring.cloud.config.name=rating-service
	spring.cloud.config.discovery.service-id=config
	spring.cloud.config.discovery.enabled=true
	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/
* Добавить файл  rating-service.properties в каталог application-config
	spring.application.name=rating-service
	server.port=8084
	eureka.client.region = default
	eureka.client.registryFetchIntervalSeconds = 5
	eureka.client.serviceUrl.defaultZone=http://localhost:8082/eureka/
* Git commit

## 6. Добавление Spring Security 
* Добавить во все сервисы spring-boot-starter-security
* Добавить  spring-session, spring-boot-starter-data-redis в сервисы discovery, gateway, flower-service, rating-service 
* Добавить в сервисы gateway, flower-service, rating-service
	@EnableRedisHttpSession
	public class SessionConfig см исходники
* Добавить в файлы конфигурации (Git repository application-config)
	spring.redis.host=localhost 
	spring.redis.port=6379
## 7. Защитить сервер конфигурации
* Добавить в файл application.properties (src/main/resources) строки
	eureka.client.serviceUrl.defaultZone=http://discUser:discPassword@localhost:8082/eureka/
	spring.security.user.name=configUser
	spring.security.user.password=configPassword
	spring.security.user.roles= SYSTEM
## 8. Защита Discovery 
* Добавить класс
	@Configuration
	@EnableWebSecurity
	@Order(1)
	public class SecurityConfig extends WebSecurityConfigurerAdapte см исходники
* Добавить строки в bootstrap.properties
	spring.cloud.config.username=configUser
	spring.cloud.config.password=configPassword
* Обновить discovery.properties 
	eureka.client.serviceUrl.defaultZone=http://discUser:discPassword@localhost:8082/eureka/
	eureka.client.register-with-eureka=false
	eureka.client.fetch-registry=false
## 9. Защита Gateway Service
 * Добавить класс SecurityConfig см исходники
 * Отредактировать SessionConfig
	@EnableRedisHttpSession( redisFlushMode = RedisFlushMode.IMMEDIATE)
 * Добавить ZuulFilter 
	@Component
	public class SessionSavingZuulPreFilter
 * Добавить в фай bootstrap.properties строки подключения к сервису конфигурации и реестра
	spring.cloud.config.username=configUser
	spring.cloud.config.password=configPassword
	eureka.client.serviceUrl.defaultZone=http://discUser:discPassword@localhost:8082/eureka/
 * Обновить gateway.properties
	management.security.sessions=always 
## 10. Защита Flower Service
 * Добавить класс SecurityConfig см исходники
 * Добавить в bootstrap.properties
	spring.cloud.config.username=configUser
	spring.cloud.config.password=configPassword
	eureka.client.serviceUrl.defaultZone=http://discUser:discPassword@localhost:8082/eureka/
 * Добавить в flower-service.properties
	management.security.sessions=never
## 11. Защита Rating Service
 * Добавить класс SecurityConfig см исходники
 * Добавить в bootstrap.properties
	spring.cloud.config.username=configUser
	spring.cloud.config.password=configPassword
	eureka.client.serviceUrl.defaultZone=http://discUser:discPassword@localhost:8082/eureka/
 * Добавить в rating-service.properties
	management.security.sessions=never
