[TOC]
# <center>Spring AOP</center>
## Aspect Oriented Programming
+ 无侵入式的添加代码，实现功能嵌入而无需产生冗余代码
+ Aspect（切面）： Aspect 类似于Java中的类声明，包含Pointcut以及相应的Advice。
+ Joint point（连接点）：在程序中明确定义的点，典型的包括方法调用，对类成员的访问以及异常处理程序块的执行等等，可以嵌套其它joint point。
+ Pointcut（切点）：表示一组joint point，它定义了相应的 Advice 将要发生的地方。
+ Advice（增强）：定义了在Pointcut具体要做的操作，before、after 和 around 来区别是在每个 joint point 之前、之后还是代替执行的代码。
+ Target（目标对象）：织入 Advice 的目标对象.。
+ Weaving（织入）：将 Aspect 和其他对象连接起来, 并创建 Adviced object 的过程

## Hello,Spring AOP
+ 引入依赖
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
+ 定义业务逻辑
+ 实现切面逻辑，定义point-cut 和 advice
## Pointcuts
### expression
+ execution()：matchs methods
  + 格式：execution(modifier-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
  + *为通配符匹配任意内容，..表示任意参数或者任意数量子包
+ within(): matchs classes
  + 出现在表达式里的任意类
+ this()/target(): matchs classes
  + this()用于匹配当前AOP代理对象类型的执行方法；包括引入接口类型匹配；
  + target(): 用于匹配当前目标对象类型的执行方法；不包括引入接口类型匹配；
+ args():matchs arguments
+ @args():匹配参数持有指定注解；
+ @target():匹配目标对象持有指定的注解；
+ @within(matchs class):匹配class持有指定注解类型；
+ @annotation(matchs method):匹配当前执行方法持有指定注解的方法；
## Advice
+ @Before:连接点前面执行，不能终止后续流程，除非抛异常
+ @After:连接点退出时执行，无论是正常退出还是异常退出,在返回结果之前
+ @Around:围绕连接点前后执行，也能捕获异常处理
  + proceed()方法区分方法执行前后
+ @AfterReturning:连接点正常返回时执行，有异常不执行
+ @AfterThrowing:连接点方法抛出异常时执行
## Global Exception Handling
+ 遇到错误抛出异常
+ 定义返回实体ResponseEntity<class>
