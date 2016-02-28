package com.company;

/**
 * Created by hackeru on 28/02/2016.
 */
public class Task {
    
    private String name;
    private boolean complete;
    private TaskCompletedListener listener;

    
    public Task(String name){
        this.name = name;
        //complete = false;
    }
    
    public String getName(){
        return name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
        if (complete){  // complete == true;
            listener.taskCompleted(this);
        }
    }

    public void setTaskCompletedListener(TaskCompletedListener listener) {
        this.listener = listener;
    }
}
