package models;

import services.AlignStrategy;

import java.util.ArrayList;

public class Paragraph implements Element{

    private String name;
    private AlignStrategy alignStrategy;
    String value;
    String oldValue;
    ArrayList<Observer> observerList=new ArrayList<Observer>();



    public Paragraph(String name){
        this.name=name;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }


    public void print(){

        if(alignStrategy==null) {
            System.out.println(this.name);
        }else{
            alignStrategy.render(this.name);
        }
    }

    public void setAlignStrategy(AlignStrategy alignStrategy){
        this.alignStrategy=alignStrategy;
    }

    public void setNewValue(String newValue){

    }
    public void addObserver(Observer obs){
        observerList.add(obs);
    }
    public void removeObserver(Observer obs){
        observerList.remove(obs);
    }
    public void notifyObservers(){
        for(Observer o : observerList){
            o.update(oldValue,value);
        }
    }
}
