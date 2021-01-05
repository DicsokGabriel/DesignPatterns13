package models;

public class SecondObserver implements Observer{
    public void update(String oldValue,String newValue){
        System.out.println("Second Observe:");
        System.out.println(oldValue);
        System.out.println(newValue);
    };
}
