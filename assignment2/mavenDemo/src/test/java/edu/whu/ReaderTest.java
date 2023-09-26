package edu.whu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void TestReader(){
        //类存在，判断正确
        assertEquals("edu.whu.Student",Reader.ReadResourceFile("myClass"));
        //类不存在但是键值对匹配，仍然判断正确
        assertEquals("edu.whu.Teacher",Reader.ReadResourceFile("faClass"));
    }
}