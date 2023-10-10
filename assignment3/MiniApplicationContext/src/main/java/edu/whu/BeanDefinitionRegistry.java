package edu.whu;

public interface BeanDefinitionRegistry {
    //添加beanDefinition对象
    void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
    //删除beanDefinition对象
    void removeBeanDefinition(String beanName);
    //获取beanDefinition对象
    BeanDefinition getBeanDefinition(String beanName) throws Exception;
    String[] getBeanDefinitionNames();
}
