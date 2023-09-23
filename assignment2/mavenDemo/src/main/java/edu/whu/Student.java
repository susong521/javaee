package edu.whu;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Student {
    int age;
    String major;
    String sex;
    public static Student createAnObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> student = Class.forName(className);
        return (Student) student.newInstance();
    }
    @initMethod
    public void init(){
        Method[] methods = Student.class.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(initMethod.class)){
                initMethod annotation=method.getAnnotation(initMethod.class);
                String[] value=annotation.value();
                this.age=Integer.parseInt(value[0]);
                this.major=value[1];
                this.sex=value[2];
            }
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className=Reader.ReadResourceFile();
        Student s=Student.createAnObject(className);
        s.init();
        System.out.println("年龄："+s.age);
        System.out.println("专业："+s.major);
        System.out.println("性别："+s.sex);
    }
}
