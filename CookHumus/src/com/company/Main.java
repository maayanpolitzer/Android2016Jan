package com.company;

public class Main {

    public static void main(String[] args) {
            //  Soaking, Cooking, Grinding
        Task[] tasks = new Task[3];
        tasks[0] = new Task("Soaking");
        tasks[1] = new Task("Cooking");
        tasks[2] = new Task("Grinding");

        Project p = new Project("Cook Humus", tasks);

        tasks[0].setComplete(true);
        tasks[1].setComplete(true);
        tasks[2].setComplete(true);

    }
}
