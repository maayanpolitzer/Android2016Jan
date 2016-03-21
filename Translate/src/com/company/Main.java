package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler, ChangeDisplayListener {

    private Button btn;
    private boolean isWorking = false;
    private TextField input;
    private TextArea output;
    private TranslateThread translate;
    private int counter = 0;
    Word[] words = {
            new Word("hello", "שלום"),
            new Word("bye", "להתראות"),
            new Word("dog", "כלב"),
            new Word("cat", "חתול"),
            new Word("sun", "שמש")
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        createUI(primaryStage);
        addActions();




    }

    public void changeDisplay(){
        if (counter == words.length){
            counter = 0;
        }
        //System.out.println(words[counter++]);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Word word = words[counter];
                input.setText(word.getEnglish());
                output.setText(word.getHebrew());
                counter++;
            }
        });
    }

    private void addActions() {
        btn.setOnAction(this);
    }

    private void createUI(Stage primaryStage) {
        VBox layout = new VBox();
        input = new TextField();
        output = new TextArea();
        btn = new Button("START");
        layout.getChildren().addAll(input, output, btn);
        Scene mainScene = new Scene(layout, 500, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
	    launch(args);
    }


    @Override
    public void handle(Event event) {
        if (!isWorking){
            btn.setText("STOP");
            translate = new TranslateThread(this);
            translate.start();
        }else{
            btn.setText("START");
            translate.setWorking(false);
        }
        isWorking = !isWorking;
    }
}
