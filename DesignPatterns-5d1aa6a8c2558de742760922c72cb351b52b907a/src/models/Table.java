package models;

import java.util.ArrayList;

public class Table implements Element{

    private String name;
    String value;
    String oldValue;
    ArrayList<Observer> observerList=new ArrayList<Observer>();


    public Table(String name){
        this.name=name;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public void print(){
        System.out.println("models.Table with name: "+this.name);
    }


    public void setNewValue(String newValue){
        oldValue=value;
        value=newValue;
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
