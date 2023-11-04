[TOC]
# <center>Spring Security</center>
## Basic Authentication
+ 引入依赖
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
+ yaml文件配置
```java
spring:
  security:
    user:
      name: admin
      password: admin
```
## UserDetailService
### In-memory UserDetailsService
+ 实现配置类SecurityConfig
+ 创建一个PasswordEncoder的Bean,实现密码加密。供认证管理器认证使用
+ 创建一个UserDetailsService，返回用户及其权限信息，供认证和授权管理器使用(如果外部创建了UserDetailService，这个Bean可以去掉)
### Load user from Database
+ 调用数据库访问接口，完成用户信息查询
## JWT Authentication
### Session-based authentication
+ 不便于分布式应用
+ 依赖于cookie
### Token-based authentication
+ 在服务器间共享secret
### JWT(JSON WEB TOKEN)
+ 令牌组成： 标头（Header） 有效载荷（Payload）签名（Signature）
### Demo
+ 引入依赖
```java
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>091</version>
</dependency>
```
## Cache
+ @Cacheable	主要针对方法配置，能够根据方法的请求参数对其进行缓存
+ @CacheEvict	清空缓存
+ @CachePut	保证方法被调用，又希望结果被缓存。
+ @EnableCaching	开启基于注解的缓存
+ value	缓存的名称，在 spring 配置文件中定义，必须指定至少一个
+ key	缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，
+ condition	缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存/清除缓存
## Authorization
