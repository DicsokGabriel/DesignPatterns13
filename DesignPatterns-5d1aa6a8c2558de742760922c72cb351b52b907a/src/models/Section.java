package models;

import java.util.ArrayList;

public class Section implements Element, Observable{

    protected String sectionTitle;
    protected ArrayList<Element> content = new ArrayList<>();
    String content1;
    String oldContent;
    ArrayList<Observer> observerList=new ArrayList<Observer>();
    public Section(String sectionTitle){
        this.sectionTitle=sectionTitle;
    }

    public int add(Element elm){
        content.add(elm);
        return content.indexOf(elm);
    }

    public void accept(Visitor v) {

        v.visit(this);
        for (Element i:content){
            i.accept(v);
        }
    }

    public void remove(Element elm){
        content.remove(elm);
    }

    public Element getElement(int index){
        return content.get(index);
    }

    public void print(){
        System.out.println("models.Section: "+this.sectionTitle);
        for(Element i : content){
            i.print();
        }
    }
    public void setNewValue(String newValue){
        oldContent=content1;
        content1=newValue;
    }
    public void addObserver(Observer obs){
        observerList.add(obs);
    }
    public void removeObserver(Observer obs){
        observerList.remove(obs);
    }
    public void notifyObservers(){
        for(Observer o : observerList){
            o.update(oldContent,content1);
        }
    }
}
