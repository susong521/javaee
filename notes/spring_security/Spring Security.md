[TOC]
# <center>Spring Security</center>
## Basic Authentication
+ ��������
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
+ yaml�ļ�����
```java
spring:
  security:
    user:
      name: admin
      password: admin
```
## UserDetailService
### In-memory UserDetailsService
+ ʵ��������SecurityConfig
+ ����һ��PasswordEncoder��Bean,ʵ��������ܡ�����֤��������֤ʹ��
+ ����һ��UserDetailsService�������û�����Ȩ����Ϣ������֤����Ȩ������ʹ��(����ⲿ������UserDetailService�����Bean����ȥ��)
### Load user from Database
+ �������ݿ���ʽӿڣ�����û���Ϣ��ѯ
## JWT Authentication
### Session-based authentication
+ �����ڷֲ�ʽӦ��
+ ������cookie
### Token-based authentication
+ �ڷ������乲��secret
### JWT(JSON WEB TOKEN)
+ ������ɣ� ��ͷ��Header�� ��Ч�غɣ�Payload��ǩ����Signature��
### Demo
+ ��������
```java
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>091</version>
</dependency>
```
## Cache
+ @Cacheable	��Ҫ��Է������ã��ܹ����ݷ������������������л���
+ @CacheEvict	��ջ���
+ @CachePut	��֤���������ã���ϣ����������档
+ @EnableCaching	��������ע��Ļ���
+ value	��������ƣ��� spring �����ļ��ж��壬����ָ������һ��
+ key	����� key������Ϊ�գ����ָ��Ҫ���� SpEL ���ʽ��д��
+ condition	���������������Ϊ�գ�ʹ�� SpEL ��д������ true ���� false��ֻ��Ϊ true �Ž��л���/�������
## Authorization
