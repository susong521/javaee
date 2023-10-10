package edu.whu;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        MyApplicationContext ctx=new MyApplicationContext("/applicationContext.xml");
        sender s = ctx.getBean("sender",sender.class);
        s.send();
        receiverImpl re=s.getRe();
        re.receive();
    }
}