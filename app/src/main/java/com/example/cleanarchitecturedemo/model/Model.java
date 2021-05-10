package com.example.cleanarchitecturedemo.model;

import android.util.Log;
import java.util.ArrayList;

public class Model {

    private ArrayList<ModelObserver> observers = new ArrayList<ModelObserver>();
    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        Log.d("CONSOLE", "Change effected in Model.");
        notifyObservers();
    }

    private void notifyObservers(){
        Log.d("CONSOLE", "Notifying ModelObservers.");
        for (ModelObserver observer : observers){
            observer.update();
        }
        Log.d("CONSOLE", "ModelObservers notified.");
    }

    public void addModelObserver(ModelObserver observer){
        if(!observers.contains(observer)) {
            observers.add(observer);
            Log.d("CONSOLE", "ModelObserver added.");
        }
    }

    public void removeModelObserver(ModelObserver observer){
        observers.remove(observer);
    }

    //Interface
    public interface ModelObserver{
        public void update();
    }
}
