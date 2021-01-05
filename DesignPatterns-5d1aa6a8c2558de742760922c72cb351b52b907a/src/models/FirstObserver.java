package models;

public class FirstObserver implements Observer{
    public void update(String oldValue,String newValue){
        System.out.println("First Observe:");
        System.out.println(oldValue);
        System.out.println(newValue);
    };
}
