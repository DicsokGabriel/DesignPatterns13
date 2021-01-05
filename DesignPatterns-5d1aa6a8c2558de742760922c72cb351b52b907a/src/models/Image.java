package models;
import services.ImageLoaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Observable{

    private String imageName;
    String value;
    String oldValue;
    ArrayList<Observer> observerList=new ArrayList<Observer>();

    public Image(String name){
        this.imageName=name;
       /* try {*/
         //   TimeUnit.SECONDS.sleep(2);
           // ImageLoaderFactory.create(name);

        /*} catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }*/
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void print(){
        System.out.println("models.Image with name: "+this.imageName);
    }

    public void setNewValue(String newValue){
        oldValue=value;
        value=newValue;
        notifyObservers();
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
