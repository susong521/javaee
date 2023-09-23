[TOC]
#  <center>java_advance<center>
## I/O��
### ����
  + �ַ���������Reader -> FileReader
  + �ֽ���������InputStream -> FileInputStream
  `�ֽ����ͣ�byte -> 8 bits ��ʾΪASCALL��`
### ���
  + �ַ��������Writer -> FileWriter
  + �ֽ��������OutputStream -> FileOutputStream
### classpath
+ ����˼�壬��·����Ϊ *.class �ļ���·����ͬʱҲ����������Դ�ļ�
+ �ļ����ط�����getResourceAsStream(String path) 
  + class���ã���Ϊ��·�� `path�ԡ�/'��ͷ,����·����ȡ�ļ�`
  + classLoader()���ã���Ϊ�������·�� `path���ԡ�/'��ͷ,�Ӵ������ڵİ���ȡ��Դ`

### Properties��Java.util.Properties��
+ ������Ҫ���ڶ�ȡJava�������ļ�����*.properties�ļ�
+ �Լ�ֵ�Ե���ʽ���в������ã�value=getProperty(key)
+ ʹ��load()���������ļ�
### File
+ ��Ϊ���󣬿ɵ���exists()�����ж��Ƿ����
+ ���÷���������isDirectory()  isFile()  list()  listFiles()
### try with resource
```java
try{
    //�����׳��쳣�Ĵ���
}
catch(){
    //�����쳣
}
finally{
    //����ִ�еĴ��룬�ͷ���Դ
}
```
### Files 
+ �����࣬�Ƚϼ򵥣������ͷŲ���(���ļ������Ƽ�ʹ��)
## Generics(����)
### why��
+  ==�������Ͱ�ȫ==:���������԰������Ǽ������ʹ���
### �������Ͳ���
![Alt text](image.png)
## Reflection(����)
### ԭ��
+ ��������󣬿���ͨ��class�������ȡ����(�ֶ�)��Ϣ
+ һ����ֻ����һ��class����
### ʹ��
+ get class  
> Class.forName(����+����)  
> ����.class  
> ����.getclass()  
+ get fields  
>public: getFields()  
>public/private: getDeclareFields()  
>getDeclareField("name")  
+ get/set field value 
>nameField.setAccessible(true);  
>nameField.get(����)  
>nameField.set(����,"fieldValue")  
+ get methods
>getMethods()  
>getDeclareMethods()  
>getMethod("name")  
+ create an object 
>Class userClass = Class.forName("name"); userClass.newInstance();  
>Constructor constructor = userClass.getConstructor(T1,T2);  constructor.newInstance(T1,T2);  
>Method method = userClass.getMethod("name",class); method.invoke(user,"name");  
## Annotation(ע��)
### why��
+ ����ע�⣬���԰���������������(����ʱ���)
### �Զ���ע��
+ ����������ע�ⷶΧ(Target)&��������(Retention)
+ Ԫע��:
![Alt text](image-1.png)
+ ע���Զ������Ը�ʽ�� type name() default value;
  `��Ĭ��ֵʱ��ʹ��ע���ʡ��value�����������ʽ����`
+ **����ͨ��������ƶ�ȡע������**
## Maven(��Ŀ������)
### what��
�Զ��ı�׼����Ŀ����(������IDEA)
### Ŀ¼�ṹ
![Alt text](IMG_2587.PNG)
### pom.xml
+ POM:��Ŀ����ģ�ͣ�maven���̵ĺ��������ļ�
+ ��ά���궨��jar��groupId artifactId version
### dependency
+ ��Χ(scope)
  + **compile**����ʾ���뷶Χ��ָ A ��**����**ʱ���� B���÷�ΧΪĬ��������Χ�����뷶Χ��������**���ڱ��룬���ԣ�����**����������ʱ��Ҫ�����Ա��뷶Χ�������ᱻ**���**��
  + **provided**��provied ����ֻ�е� jdk ����һ���������ṩ������֮���ʹ�á�provide ������**����Ͳ���ʱ��Ҫ**��������ʱ����Ҫ�����磺**servlet api**��Tomcat�����ṩ�ˡ�
  + **runtime**��runtime ������**���кͲ���ϵͳʱ��Ҫ**�����ڱ���ʱ����Ҫ�����磺**jdbc** ������������������ʱ��Ҫ������ runtime ��Χ�������ᱻ�����
  + **test**��test ��Χ�����ڱ��������ʱ������Ҫ��ֻ��**����**����Ͳ�������ʱ��Ҫ�����磺**Junit**����������ʱ����Ҫ������ test ��Χ�������ᱻ�����
  + **system**��system ��Χ������ provide ���ƣ����Ǳ�����ʾ���ṩһ�����ڱ���ϵͳ�� jar �ļ���·����һ�㲻�Ƽ�ʹ�á�
+ ���ݣ�complie�����γ��������ݣ�test��provided�����γ�
+ �ų�����������ʹ��exclusions�����������ų���������ָ���汾��
## Unit Testing��JUnit��
### �ŵ�
- ���Դ���͹��ܴ���ֿ�
- �Զ������в����ɲ��Ա���
### ����
+ ��д���������ĺ���ʵ�ַ�ʽ
+ ���ķ�����assertEquals(),assertNull(),assertSame(),assertTrue()
### ע��
+ @test�����Է������ɲ��������쳣
+ @BeforEach & @AfterEach���ظ�ִ�У���֤��ͬ�Ĳ��Ի���
+ @BeforeClass & @AfterClass��������в���ִֻ��һ��
+ @Before����ʼ������
+ @After���ͷ���Դ
  `ִ��˳��Ϊ@BeforeClass -> @Before -> @test -> @After -> @AfterClass`
### ԭ��
**F I R S T**