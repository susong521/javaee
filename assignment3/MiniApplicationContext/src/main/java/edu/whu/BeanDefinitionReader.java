package edu.whu;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanDefinitionReader {
    //声明并初始化注册表
    private BeanDefinitionRegistry beanDefinitionRegistry=new BeanDefinitionRegisterImpl();
    public BeanDefinitionRegistry getBeanDefinitionRegistry() {
        return beanDefinitionRegistry;
    }
    //读取配置文件
    public void loadBeanDefinitions(String xmlPath) throws Exception{
        //检查文件路径
        if(xmlPath==null || "".equals(xmlPath.trim())||!String.valueOf(xmlPath.charAt(0)).equals("/")){
            System.out.println("配置文件路径有误");
            return;
        }
        System.out.println("解析配置文件...");
        try(InputStream inputStream=this.getClass().getResourceAsStream(xmlPath)){
            //创建解析器对象
            SAXReader saxReader=new SAXReader();
            //根据xml文件生成document对象
            Document document = saxReader.read(inputStream);
            //获取根标签
            Element rootElement=document.getRootElement();
            List<Element> elementList=rootElement.elements();
            //遍历beans
            for(Element beanElement:elementList){
                System.out.println("子标签名称："+beanElement.getName());
                //获取属性值并创建BeanDefinition
                String id=beanElement.attributeValue("id");
                String clazz =beanElement.attributeValue("class");
                BeanDefinition beanDefinition=new BeanDefinition();
                beanDefinition.setId(id);
                beanDefinition.setBeanClass(clazz);
                List<Element> propertyElementList=beanElement.elements("property");
                for(Element propertyElement:propertyElementList){
                    String name=propertyElement.attributeValue("name");
                    String ref=propertyElement.attributeValue("ref");
                    String value=propertyElement.attributeValue("value");
                    Map<String,String> map1 = new HashMap<>();
                    if(ref!=null) map1.put("ref",ref);
                    else map1.put("value",value);
                    Map<String,Map<String,String>> map2=new HashMap<>();
                    map2.put(name,map1);
                    beanDefinition.setProperty(map2);
                }
                //将beanDefinition加入到注册表中
                beanDefinitionRegistry.registerBeanDefinition(id,beanDefinition);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
