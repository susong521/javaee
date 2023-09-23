package edu.whu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void TestStudent() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name=Reader.ReadResourceFile();
        Student s=Student.createAnObject(name);
        s.init();
        assertEquals(20,s.age);
        assertEquals("计算机科学与技术",s.major);
        assertEquals("男",s.sex);
    }


}