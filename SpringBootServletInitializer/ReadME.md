# SpringBootServletInitializer 

The SpringBootApplication, current trend is to to deploy Spring Boot Application from jar.

**Spring is a popular Java application framework.**

**Spring Boot is an effort to create stand-alone, 

production-grade Spring based applications with minimal effort.**


SpringBootServletInitializer
---
SpringBootServletInitializer is an interface to run SpringApplication from a traditional WAR deployment. 
It binds Servlet, Filter and ServletContextInitializer beans from the application context to the server.

This is the Maven build file. The spring-boot-starter-web is starter for building web, including RESTful,
applications using Spring MVC.
The application is packaged into a WAR file.


The Application sets up the Spring Boot application.
It extends from SpringBootServletInitializer so that it can be deployed as a WAR.
The application can be run both by deploying the WAR on a Tomcat server and executing 
it as a self-executable web archive with embedded Tomcat.


**OUPUT**

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.9.RELEASE)

2019-07-13 10:50:56.923  INFO 68140 --- [           main] springbatch.batch.App                    : Starting App on 10SGL5CG8524305 with PID 68140 (C:\Users\gopalakrishnanc\Documents\workspace-sts-3.9.6.RELEASE\batch\target\classes started by gopalakrishnanc in C:\Users\gopalakrishnanc\Documents\workspace-sts-3.9.6.RELEASE\batch)
2019-07-13 10:50:56.925  INFO 68140 --- [           main] springbatch.batch.App                    : No active profile set, falling back to default profiles: default
2019-07-13 10:50:56.973  INFO 68140 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@14a2ec7: startup date [Sat Jul 13 10:50:56 SGT 2019]; root of context hierarchy
2019-07-13 10:50:58.107  INFO 68140 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2019-07-13 10:50:58.116  INFO 68140 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-07-13 10:50:58.116  INFO 68140 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.23
2019-07-13 10:50:58.276  INFO 68140 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-07-13 10:50:58.277  INFO 68140 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1304 ms
2019-07-13 10:50:58.447  INFO 68140 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2019-07-13 10:50:58.451  INFO 68140 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2019-07-13 10:50:58.451  INFO 68140 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2019-07-13 10:50:58.451  INFO 68140 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2019-07-13 10:50:58.451  INFO 68140 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2019-07-13 10:50:58.919  INFO 68140 --- [           main] j.LocalContainerEntityManagerFactoryBean : Building JPA container EntityManagerFactory for persistence unit 'default'
2019-07-13 10:50:58.930  INFO 68140 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
2019-07-13 10:50:58.993  INFO 68140 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.0.12.Final}
2019-07-13 10:50:58.994  INFO 68140 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2019-07-13 10:50:58.995  INFO 68140 --- [           main] org.hibernate.cfg.Environment            : HHH000021: Bytecode provider name : javassist
2019-07-13 10:50:59.030  INFO 68140 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
2019-07-13 10:50:59.119  INFO 68140 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
2019-07-13 10:50:59.419  INFO 68140 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2019-07-13 10:50:59.884  INFO 68140 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@14a2ec7: startup date [Sat Jul 13 10:50:56 SGT 2019]; root of context hierarchy
2019-07-13 10:50:59.945  INFO 68140 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2019-07-13 10:50:59.946  INFO 68140 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2019-07-13 10:50:59.978  INFO 68140 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2019-07-13 10:50:59.979  INFO 68140 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2019-07-13 10:51:00.013  INFO 68140 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2019-07-13 10:51:00.216  INFO 68140 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2019-07-13 10:51:00.263  INFO 68140 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2019-07-13 10:51:00.295  INFO 68140 --- [           main] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
2019-07-13 10:51:00.363 DEBUG 68140 --- [           main] org.hibernate.SQL                        : 
    select
        person0_.roll_number as roll_num1_0_,
        person0_.first_name as first_na2_0_,
        person0_.last_name as last_nam3_0_,
        person0_.school as school4_0_ 
    from
        person person0_
person:springbatch.batch.Person@aeaf29[rollNumber=1,firstName=gopal,lastName=c,school=school1]
person:springbatch.batch.Person@16efa4f[rollNumber=2,firstName=gopala,lastName=c1,school=school2]
2019-07-13 10:51:00.393  INFO 68140 --- [           main] springbatch.batch.App                    : Started App in 3.703 seconds (JVM running for 4.492)
2019-07-13 10:51:12.582  INFO 68140 --- [on(2)-127.0.0.1] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
2019-07-13 10:51:12.582  INFO 68140 --- [on(2)-127.0.0.1] ationConfigEmbeddedWebApplicationContext : Closing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@14a2ec7: startup date [Sat Jul 13 10:50:56 SGT 2019]; root of context hierarchy
2019-07-13 10:51:12.583  INFO 68140 --- [on(2)-127.0.0.1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2019-07-13 10:51:12.584  INFO 68140 --- [on(2)-127.0.0.1] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'

```
