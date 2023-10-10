package edu.whu;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyApplicationContext {
    //存储使用反射创建的bean
    private Map<String,Object> beans=new HashMap<>();
    //读取配置文件
    private BeanDefinitionReader beanDefinitionReader;
    //配置文件路径
    private String xmlPath;
    //读取配置文件并存储beanDefinition
    public MyApplicationContext(String xmlPath) throws Exception {
        this.xmlPath=xmlPath;
        beanDefinitionReader=new BeanDefinitionReader();
        beanDefinitionReader.loadBeanDefinitions(this.xmlPath);
        //读取注册表获取beans对象并初始化
        BeanDefinitionRegistry beanDefinitionRegistry=beanDefinitionReader.getBeanDefinitionRegistry();
        String[] beanDefinitionNames=beanDefinitionRegistry.getBeanDefinitionNames();
        for(String beanDefinitionName:beanDefinitionNames){
            getBean(beanDefinitionName);
        }
    }
    public Object getBean(String id) throws Exception {
        Object obj = beans.get(id);
        //如果bean已经存在直接返回
        if(obj != null) return obj;
        BeanDefinitionRegistry beanDefinitionRegistry=beanDefinitionReader.getBeanDefinitionRegistry();
        BeanDefinition beanDefinition=beanDefinitionRegistry.getBeanDefinition(id);
        //如果bean未定义返回null
        if(beanDefinition==null) return null;
        //通过反射建立实例
        Class<?> clazz=Class.forName(beanDefinition.getBeanClass());
        Object bean=clazz.newInstance();
        Map<String,Map<String,String>> propertyValue=beanDefinition.getProperty();
        String[] names= propertyValue.keySet().toArray(new String[0]);
        for(String name:names){
            String propertyName=name;
            Map<String,String> valueMap=propertyValue.get(name);
            String value;
            if(valueMap.containsKey("value")){
                value=valueMap.get("value");
                if(value!=null&&!"".equals(value.trim())){
                    String setMethod=buildSetMethodName(propertyName);
                    Method[] methods=clazz.getMethods();
                    for(Method method:methods){
                        if(method.getName().equals(setMethod)){
                            method.invoke(bean,value);
                        }
                    }
                }
            }
            else {
                value=valueMap.get("ref");
                if(value!=null&&!"".equals(value.trim())){
                    Object myBean=getBean(value);
                    String setMethod=buildSetMethodName(propertyName);
                    Method[] methods=clazz.getMethods();
                    for(Method method:methods){
                        if(method.getName().equals(setMethod)){
                            method.invoke(bean,myBean);
                        }
                    }
                }
            }
        }
        beans.put(id,bean);
        return bean;
    }
    public <T> T getBean(String name,Class<? extends T> clazz) throws Exception {
        Object bean=getBean(name);
        if(bean==null) return null;
        return clazz.cast(bean);
    }
    private String buildSetMethodName(String name) {
        if (null == name || "".equals(name.trim())) {
            return "";
        }
        String upperString = name.substring(0, 1).toUpperCase() + name.substring(1);
        return "set" + upperString;
    }
}
