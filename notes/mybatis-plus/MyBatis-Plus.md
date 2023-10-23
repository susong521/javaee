[TOC]
# <center>MyBatis-Plus</center>
## 1.Spring Data
### ���ݿ�����
![Alt text](image.png)
### ORM
+ �ڶ���͹�ϵ�����ݿ�֮�佨��ӳ��
+ ����ͨ�����������ֱ�ӷ������ݿ�
+ JPA��MyBaits��ΪORM frameworks
## 2.Mybatis
### ��������
```java
//MyBatis����
<dependency>
	<groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
	<version>3.4.1</version>
</dependency>
//����MySQL���ݿ�
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.32</version>
	<scope>runtime</scope>
</dependency>
```
### Mybatis with annotation
+ @Mapper: һ������Dao��ӿ��ϣ��൱��mapper.xml�ļ������ӿ�����һ����̬�����ࡣע�⣺��Dao�㲻Ҫ������ͬ���ֵĽӿڣ�������mapper�ļ�ӳ�����
+ @MapperScan:��һ����Ŀ�д��ڶ��Dao��ӿ�ʱ����Ҫ��ÿ���ӿ�д��@Mapperע��,����ʹ��@MapperScanע�����һ���Ե�ע��
+ @Select:ȡ��mapper.xml�е�select��ǩ��ֻ�����ڷ������档
+ @TableName:����ʵ��������Ӧ������
+ @TableId:�����Ա�ʶΪ����������ͨ��typeָ�����������ķ�ʽ
  + AUTO: ���ݿ�ID��������������**ȷ�����ݿ������� ID������AUTO_INCREMENT��** ������Ч
  +	NONE: ������id���ɲ���
  +	INPUT:�û��ֹ�����id
  + ASSIGN_ID:ѩ���㷨����id(�ɼ�����ֵ�����ַ�����)
  + ASSIGN_UUID:��UUID�����㷨��Ϊid���ɲ���
+ @TableField:������������Ӧ���ֶ���,��ʵ����������ʹ��
  + exist����ʶ�������Ƿ������ݿ��д���
+ @Param:������������ΪSQL��丳ֵ
### one-to-many query
+ @Results: id��ΪΨһ��ʶ��value�洢result
+ @result��column��propery�����������ݿ������������е�������֮���ӳ���ϵ��many����һ�Զ�ӳ��
+ @Many��select����ָ��������ѯ�ķ���
## 3.MyBatis-plus
### Introduction
+ ֻ����ǿ�������ı�
+ ����Mapper���SQL
+ ���÷�ҳ���������������
### BaseMapper
+ ������һЩ������CRUD�ķ���
### QueryMrapper & LambdaQueryWrapper
```java
//1.��ͨд��
QueryMapper<T> qw= new QueryMapper<T>();
qw.gt("age",13);
//2.�������Ӳ����
QueryMapper<T> qw= new QueryMapper<T>();
qw.lamba().gt(����::Getter,13);
//3.����LambdaQueryMapper
LambdaQueryMapper<T> lqw= new LambdaQueryMapper<T>();
lqw.gt(����::Getter,13);
```
+ �Զ����ѯ
@Param(Constants.Wrapper) ���� Wrapper
����Constant.Wrapper= "ew"
### ����������
+ �Ƚ��ࣺeq,ne,gt,ge,lt,le,between
+ like�ࣺlike,likeLeft,likeRight
+ sql������in,groupBy,orderBy,having,or,and
+ **������Ĭ��Ϊand��ϵ����Ϊ��������ʾ���.or()**
### aggregation(�ۺ�)
+ querymapper.(����������).select("�ۺϱ��ʽ as ����")
### paging & sorting
1. ���÷�ҳ���
```java
@Configuration
public class MpConfig {
    @Bean
    public MybatisPlusInterceptor mpInterceptor(){
        //1.����Mp������
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        //2.��Ӿ����������
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpInterceptor;
    }
}
```
2. ��ҳ��ѯ������
```java
void testGetByPage(){
//1��׼����ҳ����
Page<User> page = Page.of(pageNo,pageSize);
//2.׼����������
page.addOrder(new OrderItem(column,asc));
//3.��ҳ��ѯ
mapper.selectPage(page, null);
}
```
## 4.Code Generation
### ����
���Ը������ݿ�������������ʵ���ࡢMapper��ȴ���
### ��������
```java
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.4.1</version>
</dependency>
<!--velocityģ������-->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.3</version>
</dependency>
```
### ����
```java
public class CodeGenerator {
    public static void main(String[] args) {
        //��������������
        AutoGenerator autoGenerator = new AutoGenerator();
        //��������Դ
        autoGenerator.setDataSource(dataSourceConfig());
        //ȫ������
        autoGenerator.setGlobalConfig(globalConfig());
        //���ð���
        autoGenerator.setPackageInfo(packageConfig());
        //�������ɲ���
        autoGenerator.setStrategy(strategyConfig());
        //ִ�����ɲ���
        autoGenerator.execute();
    }

    private static StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        //���õ�ǰ�������ɵı���������Ϊ�� �����
        strategyConfig.setInclude("user","role");
        //�������ݿ���ǰ׺���ƣ�ģ���� = ���ݿ���� - ǰ׺�� ���磺 User = tbl_user - tbl_
        //strategyConfig.setTablePrefix("tbl_");
        //�����Ƿ�����Rest���
        strategyConfig.setRestControllerStyle(true);
        // �����ֹ����ֶ���
        //strategyConfig.setVersionFieldName("version");
        // �����߼�ɾ���ֶ���
        //strategyConfig.setLogicDeleteFieldName("deleted");
        // �����Ƿ�����lombok
        strategyConfig.setEntityLombokModel(true);
        return strategyConfig;
    }
    private static PackageConfig packageConfig() {
        PackageConfig packageInfo = new PackageConfig();
        //�������ɵİ��������������λ�ò���ͻ�� ���ߵ����������·��
        packageInfo.setParent("edu.whu.demo");
        //����ʵ�������
        packageInfo.setEntity("domain");
        //�������ݲ����
        packageInfo.setMapper("dao");
        return packageInfo;
    }
    private static GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        //���ô�������λ��
        globalConfig.setOutputDir(System.getProperty("user.dir")
                +"/mybatis-plus-codegenerator/src/main/java");
        //����������Ϻ��Ƿ�����ɴ������ڵ�Ŀ¼
        globalConfig.setOpen(false);
        //��������
        globalConfig.setAuthor("jiaxy");
        //�����Ƿ񸲸�ԭʼ���ɵ��ļ�
        globalConfig.setFileOverride(true);
        //�������ݲ�ӿ�����%sΪռλ����ָ��ģ������
        globalConfig.setMapperName("%sDao");
        //����Id���ɲ���
        globalConfig.setIdType(IdType.AUTO);
        return globalConfig;
    }
    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/userDB?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
```
### multiple Modules
+ parent module 
  + ����Ҫ����ΪJar��<packageing>com</packaging>
  + ��ģ�����<modules></modules>
+ sub module
  + �̳и�ģ�飺<parent></parent>
## 5.Transaction
ʹ��@Transactional��������ع�����ֹ������������