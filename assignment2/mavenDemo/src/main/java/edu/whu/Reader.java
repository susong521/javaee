package edu.whu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reader {
    public static String  ReadResourceFile(String myKey) {
        String url="my.properties";
        Properties pros=new Properties();
        try(InputStream is=Reader.class.getClassLoader().getResourceAsStream(url)){
            if(is == null) return null;
            pros.load(is);
            return pros.getProperty(myKey);
        }
        catch (IOException e){
            System.out.println("读取配置文件失败");
            return null;
        }
    }
}
