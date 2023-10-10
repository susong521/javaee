[TOC]
# <center>Spring Core</center>
## 1.Introduction
### �ŵ�
+ �򻯿�������Ч���ɵ��������������
+ ֧�ֿ��Ʒ�ת
### Spring��ܣ�
  ![Alt text](image-1.png)
## 2.Spring IOC
### �������
  + ����ϣ��޸�һ�����룬������Ҫ�޸Ķദ����
  + ���������ʵ������ϣ�ͨ���ӿ�ʵ��ͨ�����ⲿ��������
  + ���Ʒ�ת����������Ŀ���Ȩ�ɳ���ת�Ƶ��ⲿ
### IOC����
+ �������Ĵ�������ʼ���ȹ���
+ ���������߱�����Ķ��󱻳�ΪBean
+ ��Bean֮��ʵ������ע��
## 3.����Spring��Ŀ
1. ����maven��Ŀ����pom.xml�����spring framework����(ֱ����maven repository������ش����ֹ����)
2. ��������ļ�applicationContext.xml
3. ����Java�࣬���������ļ�������bean
4. ʹ��IOC����
## 4.Beans����������
### scope(������)
+ singleton
  + Ĭ��������
  + IOC������ֻ����һ������ʵ������״̬
  + ��ʵ������ʼ��һֱ������������ٻ��˳�
+ prototyoe
  + ���������󷽲��ܹ���Ķ���ʵ��
  + ÿ��ʵ�������Լ���״̬
### instantiation(ʵ����)
```java
<!--��һ�֣���spring�����ļ���ֱ��������ȫ·����Spring���Զ����ø�����޲������췽����ʵ����Bean-->
    <bean id="springBean" class="com.powernode.spring6.bean.SpringBean"/>
</beans>
<!--�ڶ��֣���̬����ģʽ����Spring�����ļ������ĸ�����ĸ�������ȡBean-->
<!--factory-method ����ָ�����ǹ����൱�еľ�̬����-->
<bean id="star" class="com.powernode.spring6.bean.StarFactory" factory-method="get"/>
<!--�����֣�ʵ������ʵ������ͨ�� factory-bean���� + factory-method��������ͬ��ɡ�-->
<bean id="gunFactory" class="com.powernode.spring6.bean.GunFactory"/>
<!--factory-bean���Ը���Spring�����ĸ�����factory-method����Spring���øö�����ĸ�������-->
<bean id="gun" factory-bean="gunFactory" factory-method="get"/>
<!--�����֣�ͨ��FactoryBean�ӿ���ʵ�֣�factory-bean���Զ�ָ��ʵ��FactoryBean�ӿڵ��࣬factory-method���Զ�ָ��getObject()������-->
<bean id="person" class="com.powernode.spring6.bean.PersonFactoryBean"/>
```
### BeanFactory��FactoryBean
1 BeanFactory
Spring IoC�����Ķ������ӿڣ��ǹ�����
2 FactoryBean
һ���ܹ�����Springʵ����������ͨBean����Ĺ���Bean��
### init & destory method
+ init-method������bean��ʼ���������ڻص�����
+ destory-method:����bean�����������ڻص��������������ڵ�������
### InitializingBean & DisposableBean
+ InitializingBean �ӿ�Ϊ bean �ṩ�� bean ���Գ�ʼ����Ĵ���������ֻ�� afterPropertiesSet һ������������ʵ�ִ˽ӿڵ��࣬�� bean �����Գ�ʼ���󶼻�ִ�и÷�����
+ DisposableBean �ӿ�Ϊ���� bean �ṩ������������ bean ʱ�Ĵ���������ֻ�� destroy һ������������ʵ�ִ˽ӿڵ��࣬�� bean ������ʱ����ִ�и÷�����
## 5.����ע��
### ע����������
  + �����������ͺ�String
  + ����bean���ͣ����ù���bean��
  + ��������/��������
### ע�뷽��
1. ���캯��ע��
   + ʹ�ñ�ǩ��constructor-arg
   + ��ǩ�е����ԣ�
     + type��ָ��Ҫע����������ͣ�����������Ҳ�ǹ��캯����ĳ����ĳЩ����������(���Ƽ�)
     + index��ָ��Ҫע������ݸ����캯����ָ������λ�õĲ�����ֵ����0��ʼ��
     + name��ָ�������캯����ָ�����ƵĲ�����ֵ��
     + value���ṩ�������ͺ�String���͵�����
     + ref��ָ��������spring��Ioc���������г��ֹ���bean��id����name
2. set��ʽע��
   + ʹ�ñ�ǩ��property
   + ��ǩ�е����ԣ�
     + name��ָ��ע��ʱ�����õ�set��������
     + value���ṩ�������ͺ�String���͵�����
     + ref��ָ��������spring��Ioc���������г��ֹ���bean��id����name
3. ��������ע��
   + ʹ�ñ�ǩ��property
   + ��ǩ�е����ԣ�
     + name��ָ��ע��ʱ�����õ�set��������
     + ���ϸ�ֵ����
4. �Զ�װ��
   + auto-wire="byType"
      + �Զ��������������в��ң����Լ�����set���������ֵ��Ӧ��beanId
      + ��֤����bean��idΨһ ������bean��Ҫ���Զ�ע������Ե�set������ֵһ�¡�
   + auto-wire="byName"
     + �Զ��������������в��ң����Լ���������������ͬ��bean
     + ��֤����bean��classΨһ ���������bean��Ҫ���Զ�ע������Ե�����һ�£�ȫ��Ψһ��id���Կ���ʡ��
## 6.IOC Containers
### ���������ļ�
   + ������·���µ������ļ�
  ```java
  ApplicationContext ctx = new ClassPathXmlApplicationContext("xml�ļ�")
  ```
   + ���ļ�ϵͳ�¼��������ļ�
```java
ApplicationContext ctx = new FileSystemXmlApplicationContext("�ļ�����·��")
```
### ��ȡbean
```java
//by name
Class name=(Class)ctx.getBean("id");
//by name(Generic method)
Class name= ctx.getBean("id",Class.class);
//by Type
Class name= ctx.getBean(Class.class);

```
## 7.Springע��
���Լ��������ļ����ݣ����ӱ��ڹ�����߿���Ч��
### �����ע��
  + **@Component** ����עһ����ͨ��spring Bean�ࡣ
  + **@Repository**����עһ��DAO�����(���ݷ��ʲ�)
  + **@Service**����עһ��ҵ���߼������(ҵ���)
  + **@Controller**����עһ�������������(���Ʋ�)
### װ��ʱע��
   + **@Autowired**������Spring ��org.springframework����,������Ϊ������ԡ�����������������עֵ 
   + **@Resource**��������spring��ע�⣬����java.annotation���£�ʹ�ø�annotationΪĿ��beanָ��Э����Bean��
   +  **@PostConstruct** �� **@PreDestroy** ���� ʵ�ֳ�ʼ��������bean֮ǰ���еĲ���
### ��������ע��
+ @Configuration��������ǰ��ΪSpring������
+ @scope������bean������
+ @Bean����Ҫ���ڷ����ϣ������ڹ�������