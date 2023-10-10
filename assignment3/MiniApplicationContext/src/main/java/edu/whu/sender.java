package edu.whu;

public class sender {
    //一对多，可能有多个接收者
    private receiverImpl re;
    public void send(){
        System.out.println("sending to "+re.getName());
    }
    //set注入方法
    public void setReceiver(receiverImpl re){
        this.re=re;
    }

    public receiverImpl getRe() {
        return re;
    }
}
