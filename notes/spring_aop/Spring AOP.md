[TOC]
# <center>Spring AOP</center>
## Aspect Oriented Programming
+ ������ʽ����Ӵ��룬ʵ�ֹ���Ƕ�����������������
+ Aspect�����棩�� Aspect ������Java�е�������������Pointcut�Լ���Ӧ��Advice��
+ Joint point�����ӵ㣩���ڳ�������ȷ����ĵ㣬���͵İ����������ã������Ա�ķ����Լ��쳣���������ִ�еȵȣ�����Ƕ������joint point��
+ Pointcut���е㣩����ʾһ��joint point������������Ӧ�� Advice ��Ҫ�����ĵط���
+ Advice����ǿ������������Pointcut����Ҫ���Ĳ�����before��after �� around ����������ÿ�� joint point ֮ǰ��֮���Ǵ���ִ�еĴ��롣
+ Target��Ŀ����󣩣�֯�� Advice ��Ŀ�����.��
+ Weaving��֯�룩���� Aspect ������������������, ������ Adviced object �Ĺ���

## Hello,Spring AOP
+ ��������
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
+ ����ҵ���߼�
+ ʵ�������߼�������point-cut �� advice
## Pointcuts
### expression
+ execution()��matchs methods
  + ��ʽ��execution(modifier-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
  + *Ϊͨ���ƥ���������ݣ�..��ʾ��������������������Ӱ�
+ within(): matchs classes
  + �����ڱ��ʽ���������
+ this()/target(): matchs classes
  + this()����ƥ�䵱ǰAOP����������͵�ִ�з�������������ӿ�����ƥ�䣻
  + target(): ����ƥ�䵱ǰĿ��������͵�ִ�з���������������ӿ�����ƥ�䣻
+ args():matchs arguments
+ @args():ƥ���������ָ��ע�⣻
+ @target():ƥ��Ŀ��������ָ����ע�⣻
+ @within(matchs class):ƥ��class����ָ��ע�����ͣ�
+ @annotation(matchs method):ƥ�䵱ǰִ�з�������ָ��ע��ķ�����
## Advice
+ @Before:���ӵ�ǰ��ִ�У�������ֹ�������̣��������쳣
+ @After:���ӵ��˳�ʱִ�У������������˳������쳣�˳�,�ڷ��ؽ��֮ǰ
+ @Around:Χ�����ӵ�ǰ��ִ�У�Ҳ�ܲ����쳣����
  + proceed()�������ַ���ִ��ǰ��
+ @AfterReturning:���ӵ���������ʱִ�У����쳣��ִ��
+ @AfterThrowing:���ӵ㷽���׳��쳣ʱִ��
## Global Exception Handling
+ ���������׳��쳣
+ ���巵��ʵ��ResponseEntity<class>
