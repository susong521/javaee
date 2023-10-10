package edu.whu;

public class receiverImpl implements receiver{
    String name;
    @Override
    public void receive() {
        System.out.println(this.name+" is receiving...");
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}
