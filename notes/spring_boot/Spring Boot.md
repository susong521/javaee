[TOC]
# <CENTER>Spring Boot</CENTER>
## 1. Web App Basics
### HTTP
HTTPЭ��(���ı�����Э��HyperText Transfer Protocol)�����ǻ���TCPЭ���Ӧ�ò㴫��Э�飬�ǿͻ��˺ͷ���˽������ݴ����һ�ֹ���(C/S)��
### Traditional Web App
+ Ӧ�ó���Ŀͻ���Ҫ��򵥣�����Ҫ��ֻ����
+ Ӧ�ó������ڲ�֧�� JavaScript ��������й�����
+ �ŶӲ���Ϥ JavaScript �� TypeScript ����������
### SPA��ǰ��˶�����
+ Ӧ�ó�����빫��������๦�ܵķḻ���û����档
+ �Ŷ���Ϥ JavaScript �� TypeScript ������
+ Ӧ�ó�����Ϊ�������ڲ��򹫹����ͻ��˹��� API��
## 2. Hello,Spring Boot
### Spring MVC
+ Model(javabean)��View(jsp/img)��Controller(Action/servlet)��
+ ���WEB�����г���������(�������ա��ļ��ϴ�������֤�����ʻ��ȵ�)����Spring�޷켯�ɡ�֧�� RESTful����URL����
+ Spring MVC�ܹ�
![Alt text](image.png)
### SSM
+ SpringMVC+Spring+Mybatis
+ model��
![Alt text](image-1.png)
### Spring Boot
+ �������� Spring Ӧ�õĳ�ʼ��Լ��������̡�
###  Create Spring Boot 
+ with Spring Initializr(start.spring.io),download source code and open with idea
+ dependencies: Spring Web
+ Config File:yaml or properties & bulid-in or user-defined
## 3. Restful API
### @RestController & Controller@
+ @Controller for traditional MVC while
+ @RestController for Restful API
  + GetMapping()
  + PostMapping()
  + PutMapping()
  + DeleteMapping()
### Introduction
+ ����ԴΪ����
+ ͳһ�ӿڣ�POST,DELETE,PUT,PATCH,GET
+ URIָ����Դ
+ ��״̬��C/S
### ��ƹ淶
+ request������+����
![Alt text](image-2.png)
+ ״̬�룺
> 1xx�������Ϣ
2xx�������ɹ�
3xx���ض���
4xx���ͻ��˴���
5xx������������
+ Lombok(dependency)
@Data provide default setter/getter
### PostMan
+ Ϊ����֤�ӿ��ܷ��������ʣ����ǳ�����Ҫʹ�ò��Թ��ߣ��������ݽӿڽ��м�⡣
+ �ô����ӿڲ��Թ������������ڲ�д�κδ��������£��Խӿڽ��е��ú͵��ԡ�
+ @PathVariable
  + �������������ƺ���Ҫ�󶨵�url�б�������һ��ʱ,���Լ�д:
  ```java
  @RequestMapping("/{name}")
    public User getUser(@PathVariable String name){
       ...
    }
  ```
  + �������������ƺ���Ҫ�󶨵�url�б������Ʋ�һ��ʱ��д��:
  ```java
  @RequestMapping("/{name}")
    public User getUser(@PathVariable("name") String userName){
       ...
    }
  ```
+ @RequestBody & @RequestParam
  + �ں�˵�ͬһ�����շ����@RequestBody��@RequestParam()����ͬʱʹ�ã�@RequestBody���ֻ����һ������@RequestParam()�����ж����
## 4. Swagger
### Introdution
+ ΪAPI�����ĵ�,�����ڽ���ӿڹ淶������׼�����ĵ����Ŀ�Դ��
+ ��������(springfox)
### Annotation
+ �������ע��
  + @Api����Դ���� values,**tags**,cosumes,etc.
  + @Apilgnore:��Դ����
  ���ĵ������νӿ�
+ ���ڷ�����ע��
  + @ApiOperation����������
  **value**,**notes**,tags,etc.
  + @ApilmplicitParam:��������,�����ڷ���ǰ
  name,value,required,param Type,etc.
  + ApiParam:��������������ÿ������ǰ��
  **name**,**value**,required,etc.
+ ����ʵ�����ע��
  + @ApiModel:ʵ��������
  **value**(ʵ���౸����)��description��etc.
  + @ApiModelProperty:ʵ�����Ա����
  **value**(�ֶ�˵��),name,required
## 5. Vue + Rest API
### add front-end files into a Springboot project
+ index.html is the default page
### Vue 
+ �����û�����Ľ���ʽ���
+ ����MVVM����˫�����ݰ󶨵�Javascript��
### Element-UI
+ һ�׻���Vue2.0������������
### Axios
+ һ������ promise �� HTTP �⣬���Է���get��post����