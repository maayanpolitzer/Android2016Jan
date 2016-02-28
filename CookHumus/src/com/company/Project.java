package com.company;

/**
 * Created by hackeru on 28/02/2016.
 */
public class Project implements TaskCompletedListener {

    private String name;
    private Task[] tasks;

    public Project(String name, Task[] tasks){
        this.name = name;
        this.tasks = tasks;
        if(tasks != null && tasks.length > 0){
            for (Task task : tasks){
                task.setTaskCompletedListener(this);
            }
        }
    }

    public void closeProject(){
        System.out.println("Project " + name + " is DONE!!!");
    }


    @Override
    public void taskCompleted(Task task) {
        System.out.println("task " + task.getName() + " is completed");
        for (Task t : tasks){
            if (!t.isComplete()){
                return;
            }
        }
        closeProject();
        /*
        boolean allCompleted = true;
        for (Task task : tasks){
            if (!task.isComplete()){
                allCompleted = false;
            }
        }
        if (allCompleted){  //  allCompleted == true
            closeProject();
        }
        */
    }
}
