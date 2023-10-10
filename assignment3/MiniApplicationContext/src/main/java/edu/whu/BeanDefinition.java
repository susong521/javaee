package edu.whu;

import java.util.Map;

public class BeanDefinition {
    private String id;
    private String beanClass;
    private Map<String,Map<String,String>> property;
    public void setId(String id){
        this.id=id;
    }
    public void setBeanClass(String beanClass){
        this.beanClass=beanClass;
    }
    public void setProperty(Map<String,Map<String,String>> property){
        this.property=property;
    }
    public String getId(){
        return this.id;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public Map<String, Map<String, String>> getProperty() {
        return property;
    }
}
