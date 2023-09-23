package edu.whu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void TestReader(){
        assertEquals("edu.whu.Student",Reader.ReadResourceFile());
    }
}